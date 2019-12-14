package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.model.Person;
import gruppe3.todoliste.service.ListService;
import gruppe3.todoliste.service.LoginService;
import gruppe3.todoliste.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public PersonController(PersonService personService, LoginService loginService, ListService listService) {
        this.personService = personService;
        this.loginService = loginService;
        this.listService = listService;
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, @Valid String username, @Valid  @ModelAttribute Login login, HttpSession session) {
        List list = new List();
        model.addAttribute(list);
        model.addAttribute(username);
        if (loginService.getLogin(username).getUsername() == null || loginService.getLogin(username).getUsername().equals("")) {
            Person person = login.getPersonFk();
            personService.addPerson(person);
            loginService.addLogin(login);
            session.setAttribute("user", username);
            model.addAttribute(username);
            model.addAttribute(login);
            return "todoForm";
        } else {
            java.util.List<List> todos = listService.getAllList();
            model.addAttribute(todos);
            return "home";
        }
    }

    @PostMapping("/loginPerson")
    public String loginPerson(Model model, @Valid String username, @Valid String password, HttpSession session) {
        List list = new List();
        model.addAttribute(list);
        if (loginService.getLogin(username).getPassword().equals(password)) {
            session.setAttribute("user", username);
            Login login1 = loginService.getLogin((String) session.getAttribute("user"));
            model.addAttribute(login1);
            model.addAttribute(username);
            return "todoForm";
        }
        Person person = new Person();
        Login login = new Login();
        login.setPersonFk(person);
        java.util.List<List> todos = listService.getAllList();
        model.addAttribute(login);
        model.addAttribute(todos);
        return "home";
    }

}

