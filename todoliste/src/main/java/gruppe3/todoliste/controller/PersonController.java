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

    public PersonController(PersonService personService, LoginService loginService) {
        this.personService = personService;
        this.loginService = loginService;
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, @Valid String username, HttpSession session) {
        List list = new List();
        model.addAttribute(list);
        Login login1 = new Login();
        Person person = new Person();
        model.addAttribute(username);
        List todos = new List();
        model.addAttribute(todos);
        model.addAttribute(list);
        if(loginService.getLogin(username)==null){
            session.setAttribute("user", username);
            login1 = loginService.getLogin((String) session.getAttribute("user"));
            person = login1.getPersonFk();
            model.addAttribute(username);
        } else {
            return "home";
        }
        model.addAttribute(login1);
        return "todoForm";
    }

    @PostMapping("/loginPerson")
    public String loginPerson(Model model, @Valid String username, @Valid String password, HttpSession session) {
        List list = new List();
        model.addAttribute(list);
        if(loginService.getLogin(username).getPassword().equals(password)){
            session.setAttribute("user", username);
            Login login1 = loginService.getLogin((String) session.getAttribute("user"));
            model.addAttribute(login1);
            model.addAttribute(username);
            return "todoForm";
        }
        Person person = new Person();
        Login login = new Login();
        login.setPersonFk(person);
        model.addAttribute(login);
        return "home";
    }

}

