package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.entity.PersonNew;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @RequestMapping("/{id}")
    @ResponseBody
    public PersonNew getOne(@PathVariable long id) {
        return personDao.findById(id);
    }

    @RequestMapping("/save")
    @ResponseBody
    public String save() {
        PersonNew person = new PersonNew();
        person.setEmail("jaja@coderslab.pl");
        person.setLogin("Bruce Eckel");
        person.setPassword("111");
        PersonDetails personDetails = new PersonDetails();
        personDetails.setCity("City");
        personDetails.setFirstName("A");
        personDetails.setLastName("AZ");
        personDetails.setStreet("street");
        personDetails.setStreetNumber("1");
        person.setPersonDetails(personDetails);
        personDao.save(person);
        return "Id dodanej persona to:" + person.getId();
    }

    @RequestMapping("/update/{id}")
    @ResponseBody
    public String update(@PathVariable long id) {
        PersonNew person = personDao.findById(id);
        person.setEmail("jaja3232@coderslab.pl");
        person.setLogin("Bruce Eckel32");
        person.setPassword("111");
        PersonDetails personDetails = person.getPersonDetails();
        personDetails.setCity("City32");
        personDetails.setFirstName("Aa");
        personDetails.setLastName("AZ32");
        personDetails.setStreet("stree32");
        personDetails.setStreetNumber("132");
        personDao.save(person);
        return "Id zmienionej persona to:" + person.getId();
    }

    @RequestMapping("/remove/{id}")
    @ResponseBody
    public String remove(@PathVariable long id) {
        personDao.delete(id);
        return "Id usuniętej persona to:" + id;
    }
}
