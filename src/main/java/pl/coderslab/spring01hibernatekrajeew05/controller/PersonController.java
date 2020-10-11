package pl.coderslab.spring01hibernatekrajeew05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.spring01hibernatekrajeew05.model.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/form")
    public String personForm(){
        return "person/form";
    }

    @PostMapping("/form")
    public String personFormPost(@RequestParam String login,
                                 @RequestParam String password,
                                 @RequestParam String email,
                                 Model m){
        Person p = new Person()
                .setLogin(login)
                .setPassword(password)
                .setEmail(email);

        m.addAttribute("person", p);

        return "person/show";
    }
}
