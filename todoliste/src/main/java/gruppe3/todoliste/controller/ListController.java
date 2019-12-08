package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ListController {

    private final ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    /**
     * @param todo  Todo welche hinzugefügt wird
     * @param model spring framework model
     * @return todoForm wird aktualisiert
     */
    @PostMapping("/add")
    public String todo(@Valid @ModelAttribute List todo, Model model) {

        listService.addList(todo);
        model.addAttribute("list", todo);

        return "home";

    }/**/

    /**
     * @param model spring framework model
     * @return todoForm wird angezeigt
     */
    @GetMapping("/todoform")
    public String showForm(Model model, HttpSession session) {
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user") != null || session.getAttribute("user") != "") {
            List list = new List();
            String username = "";
            model.addAttribute(username);
            model.addAttribute(list);
            model.addAttribute("todos", new List());
            return "todoForm";
        }
        return "home";
    }

    /**
     * @param model spring framework model
     * @param id    todo welche gelöscht werden soll
     * @return home wird angezeigt
     */
    @GetMapping(value = "/delete", params = {"id"})
    public String delete(@RequestParam(name = "id") Long id, Model model) {
        listService.deleteList(id);
        model.addAttribute("todos", listService.getAllList());
        return "home";
    }

    /**
     * @param model spring framework model
     * @param id    todo welche bearbeitet werden soll
     * @return todoForm wird angezeigt
     */
    @GetMapping(value = "/edit", params = {"id"})
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        String username = "";
        model.addAttribute(username);

        model.addAttribute("todos", listService.getList(id));
        return "todoForm";
    }

    /**
     * @param model spring framework model
     * @param id    todo welche aktualisiert werden soll
     * @return todoForm wird angezeigt
     */
    @GetMapping(value = "/update", params = {"id"})
    public String update(@RequestParam(name = "id") Long id, Model model) {

        listService.editList(id);
        return "home";
    }

}
