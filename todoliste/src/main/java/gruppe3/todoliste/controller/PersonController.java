package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.model.Person;
import gruppe3.todoliste.service.ListService;
import gruppe3.todoliste.service.LoginService;
import gruppe3.todoliste.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 */
@Controller
@RequestMapping("/todo")
public class PersonController {
    private final PersonService personService;
    private final LoginService loginService;
    private final ListService listService;

    public PersonController(PersonService personService, LoginService loginService,ListService listService) {
        this.personService = personService;
        this.loginService = loginService;
        this.listService = listService;
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, @Valid @ModelAttribute Person person, @Valid @ModelAttribute Login login) {
        personService.addPerson(person);
        login.setPersonFk(person);
        loginService.addLogin(login);
        model.addAttribute(login);
        return "home";
    }

    @PostMapping("/loginPerson")
    public String loginPerson(Model model, @Valid @ModelAttribute Login login) {
        loginService.addLogin(login);
        model.addAttribute(login);
        return "home";
    }

}

