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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 */
@Controller
@RequestMapping("/todo")
public class HelperController {
    private final PersonService personService;
    private final LoginService loginService;
    private final ListService listService;

    public HelperController(PersonService personService, LoginService loginService,ListService listService) {
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
        Person person = new Person();
        List todo = new List();
        Login login = new Login();
        login.setPersonFk(person);
        model.addAttribute(login);
        model.addAttribute(todo);
        return "home";
    }

    @GetMapping("/admin")
    public String addAdmin(Model model) {
        if(loginService.getLogin("admin").getUsername() == null || loginService.getLogin("admin").getUsername().equals("")){
            Person person = new Person("Admin", "Admin");
            person = personService.addPerson(person);
            Login login = new Login("admin", "123",person);
            loginService.addLogin(login);
            List todos = new List("2019-11-30","Test",person);
            List list = new List("2019-11-30","Test",person);
            listService.addList(todos);
            listService.addList(list);
            model.addAttribute(login);
            model.addAttribute(todos);
        } else {
            Login login = loginService.getLogin("admin");
            Person person = login.getPersonFk();
            List todos = new List();
            List list = new List();
            model.addAttribute(login);
            model.addAttribute(todos);
            model.addAttribute(list);
        }
        return "home";
    }

    @PostMapping("/admin/todos")
    public String adminTodos(Model model, HttpSession session) {
        List list = new List();
        model.addAttribute(list);
        session.setAttribute("user", "admin");
        Login login = loginService.getLogin((String) session.getAttribute("user"));
        List todos = listService.getList(login.getPersonFk().getId());
        model.addAttribute(todos);
        String username = "admin";
        model.addAttribute(username);
        return "todoForm";
    }


}

