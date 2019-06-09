package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorDao authorDao;

    @RequestMapping("/{id}")
    @ResponseBody
    public Author getOne(@PathVariable long id) {
        return authorDao.findById(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Author author = new Author();
        author.setFirstName("Thinking in Java");
        author.setLastName("Bruce Eckel");
        authorDao.save(author);
        return "Id dodanej authora to:" + author.getId();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        Author author = authorDao.findById(id);
        author.setFirstName("Thinking in Java - update");
        author.setLastName("Bruce Eckel - update");
        authorDao.update(author);
        return "Id zmienionej authora to:" + author.getId();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        authorDao.delete(id);
        return "Id usuniętej authora to:" + id;
    }
}
