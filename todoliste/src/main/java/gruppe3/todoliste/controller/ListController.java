package gruppe3.todoliste.controller;

import gruppe3.todoliste.model.List;
import gruppe3.todoliste.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


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
     *
     * @param todo Todo welche hinzugefügt wird
     * @param model spring framework model
     * @return todoForm wird aktualisiert
     */
    @PostMapping("/add")
    public String todo(@ModelAttribute List todo, Model model) {

        listService.addList(todo);
        model.addAttribute("list", new List());

        return "redirect:/home";

    }/**/

    @GetMapping
    public String showForm(Model model){
        model.addAttribute("list", new List());
        return "todoForm";
    }

    @GetMapping(value = "/delete", params ={"id"})
    public String delete (@RequestParam(name ="id")Long id, Model model){
        listService.deleteList(id);
        model.addAttribute("todos", listService.getAllList());
        return "redirect:/home";
    }

}
