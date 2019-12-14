package gruppe3.todoliste.service;

import gruppe3.todoliste.model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.ListRepository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * service to add a module, get a module with its id or remove a module
 * Refactoring proposal 3: Author is missing in the class comment
 * Author: Michael Zihlmann
 */
@Service
public class ListService {

    @Autowired
    private ListRepository listRepository;

    public ListService(ListRepository listRepository) {

        this.listRepository = listRepository;
    }

    /**
     * to add and save a module in the table module
     * @param list: module to save
     * @return id of the entry
     *
     * Refactoring proposal 4: variable should be more than one character
     * Changed List l --> List list
     */
    public Long addList(@Valid List list){

        return listRepository.saveAndFlush(list).getId();
    }

    /**
     * to get a module form the table module with a id
     * @param id: id of a module
     * @return module with the correct id from the table module
     *
     * Refactoring proposal 1: the code for the if-loop should be consistent
     * Adding { } for the second if-loop
     */
    public List getList(Long id){
        List module = new List();
        if(id != null){
            Optional<List> optionalList = listRepository.findById(id);
            if (optionalList.isPresent()) {
                module = optionalList.get();
            }
        }
        return module;

    }

    /**
     * Refactoring proposal 5: Add comment to this method
     * @return: This Method returns the whole list from <List>
     */
    public java.util.List<List> getAllList(){
        return listRepository.findAll();
    }

    /**
     *Refactoring proposal 2: Comments should be in English
     * @param id : Which ID can be cancelled
     */
    public void deleteList(Long id){
        List list = getList(id) ;
        listRepository.delete(list);
    }

    /**
     *Refactoring proposal 2: Comments should be in English
     * @param id : Which ID can be edited
     */
    public void editList(Long id){
        List list = getList(id) ;
        listRepository.save(list);
    }
}
