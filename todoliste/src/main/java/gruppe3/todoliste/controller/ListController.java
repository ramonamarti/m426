package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.service.ListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


/**
 * controller to manage the pages of the category admin and all general pages like home, password check, login and out
 * @Author: Carlos Sampaio Peredo  // -- Refactoring Michael: add author
 */
@Controller
@RequestMapping("/todo")
public class ListController {

    // CONSTANT LIST_SERVICE provides a service to add a module, get a module with its id or remove a module -- Refactoring Michael: add comment
    private final ListService LIST_SERVICE; // -- Refactoring Michael: rename to LIST_SERVICE

    public ListController(ListService listService) {
        this.LIST_SERVICE = listService;
    }

    /**
     * @param todo entry to add  -- Refactoring Michael: comment in englisch
     * @param model spring framework model
     * @return updated todoForm  -- Refactoring Michael: comment in englisch
     */
    @PostMapping("/add")
    public String todo(@Valid @ModelAttribute List todo, Model model) {

        LIST_SERVICE.addList(todo);
        model.addAttribute("list", todo);

        return "home";

    }/**/

    /**
     * @param model spring framework model
     * @return todoForm is displayed  -- Refactoring Michael: comment in englisch
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
     * @param id    todo which should be deleted  -- Refactoring Michael: comment in englisch
     * @return home is displayed  -- Refactoring Michael: comment in englisch
     */
    @GetMapping(value = "/delete", params = {"id"})
    public String delete(@RequestParam(name = "id") Long id, Model model) {
        LIST_SERVICE.deleteList(id);
        model.addAttribute("todos", LIST_SERVICE.getAllList());
        return "home";
    }

    /**
     * @param model spring framework model
     * @param id    todo which should be processed  -- Refactoring Michael: comment in englisch
     * @return todoForm is displayed  -- Refactoring Michael: comment in englisch
     */
    @GetMapping(value = "/edit", params = {"id"})
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        String username = "";
        model.addAttribute(username);

        model.addAttribute("todos", LIST_SERVICE.getList(id));
        return "todoForm";
    }

    /**
     * @param model spring framework model
     * @param id    todo which should be updated  -- Refactoring Michael: comment in englisch
     * @return todoForm is displayed  -- Refactoring Michael: comment in englisch
     */
    @GetMapping(value = "/update", params = {"id"})
    public String update(@RequestParam(name = "id") Long id, Model model) {

        LIST_SERVICE.editList(id);
        return "home";
    }

}
