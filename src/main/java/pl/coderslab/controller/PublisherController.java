package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private PublisherDao publisherDao;

    @RequestMapping("/{id}")
    @ResponseBody
    public Publisher getOne(@PathVariable long id) {
        return publisherDao.findById(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        Publisher Publisher = new Publisher();
        Publisher.setName("Thinking in Java");
        publisherDao.save(Publisher);
        return "Id dodanej publishera to:" + Publisher.getId();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        Publisher Publisher = publisherDao.findById(id);
        Publisher.setName("Thinking in Java - update");
        publisherDao.update(Publisher);
        return "Id zmienionej publishera to:" + Publisher.getId();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        publisherDao.delete(id);
        return "Id usuniętej publishera to:" + id;
    }
}
