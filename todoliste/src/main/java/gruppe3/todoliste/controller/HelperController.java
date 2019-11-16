package gruppe3.todoliste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 */
@Controller
@RequestMapping("/todoliste")
public class HelperController {
    //private final StudentService studentService;

//    public HelperController(StudentService studentService) {
//        this.studentService = studentService;
//    }

//    /**
//     * creates test data to insert into database
//     *
//     * @param model: model for thymeleaf
//     * @return html document home
//     */
    // load admin test data (hidden)
//    @GetMapping("/admin")
//    public String admin(Model model) {
//        Student student = new Student("Test", "Admin", "admin");
//        student.setDirection(Direction.Applikation);
//        student.setPassword("admin");
//        student.setStreet("Alte Landstrasse 17");
//        student.setDeactivated(Bool.Nein);
//        City city = new City("4658", "Däniken");
//        city.setDeactivated(Bool.Nein);
//        student.setCity(city);
//        Module module1 = new Module(104, "Mod1");
//        module1.setState(State.Abgeschlossen);
//        module1.setTeacher("Herr XY");
//        module1.setDirection(Direction.ICT);
//        module1.setDeactivated(Bool.Nein);
//        Module module2 = new Module(304, "Mod2");
//        module2.setState(State.Offen);
//        module2.setTeacher("Frau XX");
//        module2.setDirection(Direction.Systemsechtnik);
//        module2.setDeactivated(Bool.Nein);
//        Exam exam1 = new Exam(Type.Zwischenprüfung);
//        exam1.setState(State.Offen);
//        exam1.setDeactivated(Bool.Nein);
//        Exam exam2 = new Exam(Type.Endprüfung);
//        exam2.setState(State.Abgeschlossen);
//        exam2.setDeactivated(Bool.Nein);
//        Exam exam3 = new Exam(Type.Projekt);
//        exam3.setState(State.In_Arbeit);
//        exam3.setDeactivated(Bool.Nein);
//        Exam exam4 = new Exam(Type.Zwischenprüfung);
//        exam4.setState(State.Offen);
//        exam4.setDeactivated(Bool.Nein);
//        Grade grade1 = new Grade(5.0, 0.4);
//        grade1.setColor(Color.Gruen);
//        grade1.setDeactivated(Bool.Nein);
//        Grade grade2 = new Grade(3.0, 0.3);
//        grade2.setColor(Color.Rot);
//        grade2.setDeactivated(Bool.Nein);
//        Grade grade3 = new Grade(4.3, 0.6);
//        grade3.setColor(Color.Schwarz);
//        grade3.setDeactivated(Bool.Nein);
//        Grade grade4 = new Grade(5.9, 0.4);
//        grade4.setColor(Color.Schwarz);
//        grade4.setDeactivated(Bool.Nein);
//        exam1.setGrade(grade1);
//        exam2.setGrade(grade2);
//        exam3.setGrade(grade3);
//        exam4.setGrade(grade4);
//        List<Exam> examList = new ArrayList<>();
//        examList.add(exam1);
//        examList.add(exam2);
//        List<Exam> exams = new ArrayList<>();
//        exams.add(exam3);
//        exams.add(exam4);
//        module1.setExams(examList);
//        module2.setExams(exams);
//        List<Module> modules = new ArrayList<>();
//        modules.add(module1);
//        modules.add(module2);
//        student.setModules(modules);
//        List<Grade> grades = new ArrayList<>();
//        grades.add(grade1);
//        grades.add(grade2);
//        grades.add(grade3);
//        grades.add(grade4);
//        student.setGrades(grades);
//        Double gradeVal1 = student.getModules().get(0).getExams().get(0).getGrade().getValue();
//        Double gradeVal2 = student.getModules().get(0).getExams().get(1).getGrade().getValue();
//        Double gradeVal3 = student.getModules().get(1).getExams().get(0).getGrade().getValue();
//        Double gradeVal4 = student.getModules().get(1).getExams().get(1).getGrade().getValue();
//        gradeColor(gradeVal1, 0, student.getModules().get(0));
//        gradeColor(gradeVal2, 1, student.getModules().get(0));
//        gradeColor(gradeVal3, 0, student.getModules().get(1));
//        gradeColor(gradeVal4, 1, student.getModules().get(1));
//        studentService.addStudent(student);
//        model.addAttribute(student);
//        Direction[] directions = Direction.values();
//        model.addAttribute(directions);
//        return "home";
//    }
//
//    /**
//     * to login with admin data
//     *
//     * @param model:   model for thymeleaf
//     * @param session: to save the login name
//     * @return html document module with admin user
//     */
//    // login with admin data (hidden)
//    @PostMapping("/admin/module")
//    public String adminModule(Model model, HttpSession session) {
//        Module module = new Module();
//        model.addAttribute(module);
//        session.setAttribute("user", "admin");
//        Student student = studentService.getStudent((String) session.getAttribute("user"));
//        moduleInfo(model, student);
//        return "module";
//    }

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

//    /**
//     * shows module page for user with login name
//     *
//     * @param login:    receives login name for form input
//     * @param password: receives password for form input
//     * @param model:    model for thymeleaf
//     * @param session:  to save the login name
//     * @return html document home
//     */
//    @PostMapping("/login/module")
//    public String loginModule(@Valid String login, @Valid String password, Model model, HttpSession session) {
//        if (studentService.getStudent(login).getDeactivated().equals(Bool.Nein)) {
//            Module module = new Module();
//            model.addAttribute(module);
//            if (studentService.getStudent(login).getPassword().equals(password)) {
//                session.setAttribute("user", login);
//                Student student = studentService.getStudent((String) session.getAttribute("user"));
//                moduleInfo(model, student);
//                return "module";
//            } else {
//                return "fail";
//            }
//        } else {
//            return "fail";
//        }
//    }
//
//    /**
//     * to logout to the home page and remove session
//     *
//     * @param model:   model for thymeleaf
//     * @param session: to remove the login name
//     * @return html document home
//     */
//    @GetMapping("/logout")
//    public String logout(Model model, HttpSession session) {
//        session.removeAttribute("user");
//        Student student = new Student();
//        model.addAttribute(student);
//        studentInfo(model);
//        return "home";
//    }
//
//    /**
//     * to show that the password is changed
//     *
//     * @param id:       id of the student to change password
//     * @param password: new password to change
//     * @param model:    model for thymeleaf
//     * @return html document check password
//     */
//    @PostMapping("/password/check")
//    public String checkE(@Valid Long id, @Valid String password, Model model) {
//        Student student = studentService.getStudent(id);
//        student.setPassword(password);
//        model.addAttribute("student", student);
//        studentService.addStudent(student);
//        studentInfo(model);
//        return "checkPassword";
//    }
//
//    /**
//     * sets the color of a grade with its value
//     *
//     * @param grade:  grade value to define color
//     * @param index:  index of the exam of the grade to set color
//     * @param module: module of the exam of the grade to set color
//     */
//    private void gradeColor(double grade, int index, Module module) {
//        if (grade >= 5) {
//            module.getExams().get(index).getGrade().setColor(Color.Gruen);
//        } else if (grade >= 4) {
//            module.getExams().get(index).getGrade().setColor(Color.Schwarz);
//        } else {
//            module.getExams().get(index).getGrade().setColor(Color.Rot);
//        }
//    }
}

