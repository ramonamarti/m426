package gruppe3.todoliste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 */
@Controller
@RequestMapping("/todoliste")
public class HelperController {
    //private final StudentService studentService;

    public HelperController() {
//        this.studentService = studentService;
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

}

