package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Skill;
import pl.coderslab.entity.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple() {
        return "form/registerSimple.jsp";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(@RequestParam String firstName,
                                @RequestParam String lastName, Model model) {
        Student student = new Student(firstName, lastName);
        model.addAttribute("student", student);
        return "form/registerSimple.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student("Jan","Kowalski");
        model.addAttribute("student", student);
        return "form/registerForm.jsp"; }

    @RequestMapping(value = "/register2", method = RequestMethod.GET)
    public String showRegistrationForm2(Model model) {
        model.addAttribute("student", new Student());
        return "form/registerForm.jsp"; }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Student student) {
        System.out.println(student.getFirstName());
        return "form/registerForm.jsp";
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @ModelAttribute("skills")
    public Collection<Skill> skills() {
        List<Skill> skills = new ArrayList<Skill>();
        skills.add(new Skill(1, "Java"));
        skills.add(new Skill(2, "PHP"));
        skills.add(new Skill(3, "Ruby"));
        return skills;
    }

}
