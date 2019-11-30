package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.model.Person;
import gruppe3.todoliste.service.ListService;
import gruppe3.todoliste.service.LoginService;
import gruppe3.todoliste.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 */
@Controller
@RequestMapping("/todoliste")
public class HelperController {
    private final PersonService personService;
    private final LoginService loginService;
    private final ListService listService;


    public HelperController(PersonService personService, LoginService loginService, ListService listService) {
        this.personService = personService;
        this.loginService = loginService;
        this.listService = listService;
    }


    /**
     * shows login and registration page
     *
     * @param model: model for thymeleaf
     * @return html document home
     */
    @GetMapping
    public String showLogin(Model model) {
//        Person person = new Person();
//        model.addAttribute(person);
//        Direction[] directions = Direction.values();
//        model.addAttribute(directions);
//        model.addAttribute("no", Bool.Nein);
//        Bool[] bools = Bool.values();
//        model.addAttribute(bools);
//        List<Person> persons = personService.findPerson();
//        System.out.println(persons);
//        model.addAttribute(persons);
        Person person = new Person();
        Login login = new Login();
        login.setPersonFk(person);
        model.addAttribute(person);
        return "login-test";
    }

    @PostMapping("/login-test")
    public String addPerson(Model model, @Valid @ModelAttribute Person person, @Valid @ModelAttribute Login login) {
        List<Person> allPersons = personService.findPerson();
        List<Login> allLogins = loginService.findLogin();
        if(!allPersons.contains(person)){
            personService.addPerson(person);
        } else {
            personService.getPerson(person.getId());
        }
        login.setPersonFk(person);
        boolean passwordCriteria = login.getPassword().length()>=8;
        if(!allLogins.contains(login) && passwordCriteria){
            loginService.addLogin(login);
            model.addAttribute(login);
            return "login-test";
        }
        return "home";
    }

    @PostMapping("/board")
    public String loginBoard(Model model, @Valid @ModelAttribute Login login) {

        loginService.addLogin(login);
        model.addAttribute(login);
        return "login-test";
    }
}

