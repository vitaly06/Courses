package ru.oksei.Courses.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.oksei.Courses.DAO.PersonDAO;
import ru.oksei.Courses.Models.Person;

import java.util.Objects;

@Controller
public class MainController {
    boolean isAuth = false;
    @Autowired
    PersonDAO personDAO;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @PostMapping("/")
    public String login(@ModelAttribute("person") Person person){
        Person user = personDAO.Login(person);
        if (!Objects.equals(user.getEmail(), null) && !Objects.equals(user.getPassword(), null)){
            isAuth = true;
            System.out.println(1);
            return "redirect:/";
        }
        return "none";
    }
}
