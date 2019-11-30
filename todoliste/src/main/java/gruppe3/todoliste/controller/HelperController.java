package gruppe3.todoliste.controller;

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

import javax.validation.Valid;

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
//        Student student = new Student();
//        model.addAttribute(student);
//        Direction[] directions = Direction.values();
//        model.addAttribute(directions);
//        model.addAttribute("no", Bool.Nein);
//        Bool[] bools = Bool.values();
//        model.addAttribute(bools);
//        List<Student> students = studentService.findStudent();
//        System.out.println(students);
//        model.addAttribute(students);
        return "home";
    }

    @PostMapping("/addPerson")
    public String addPerson(Model model, @Valid @ModelAttribute Person person, @Valid @ModelAttribute Login login) {
        personService.addPerson(person);
        login.setPersonFk(person);
        loginService.addLogin(login);
        model.addAttribute(login);
        return "home";
    }
}

