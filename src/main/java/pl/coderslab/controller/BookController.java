package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @RequestMapping("/{id}")
    @ResponseBody
    public Book getOne(@PathVariable long id) {
        return bookDao.findById(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setAuthor("Bruce Eckel");
        bookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        Book book = bookDao.findById(id);
        book.setTitle("Thinking in Java - update");
        book.setAuthor("Bruce Eckel - update");
        bookDao.update(book);
        return "Id zmienionej książki to:" + book.getId();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        bookDao.delete(id);
        return "Id usuniętej książki to:" + id;
    }
}
