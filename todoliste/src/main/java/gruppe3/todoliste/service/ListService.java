package gruppe3.todoliste.service;

import gruppe3.todoliste.model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.ListRepository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * service to add a module, get a module with its id or remove a module
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
     * @param l: module to save
     * @return id of the entry
     */
    public Long addList(@Valid List l){

        return listRepository.saveAndFlush(l).getId();
    }

    /**
     * to get a module form the table module with a id
     * @param id: id of a module
     * @return module with the correct id from the table module
     */
    public List getList(Long id){
        List module = new List();
        if(id != null){
            Optional<List> optionalList = listRepository.findById(id);
            if(optionalList.isPresent())
                module = optionalList.get();
        }
        return module;

    }

    public java.util.List<List> getAllList(){
        return listRepository.findAll();
    }

    /**
     *
     * @param id welche id gelöscht werden soll
     */
    public void deleteList(Long id){
        List list = getList(id) ;
        listRepository.delete(list);
    }

    /**
     *
     * @param id welche todo gelöscht werden soll
     */
    public void editList(Long id){
        List list = getList(id) ;
        listRepository.save(list);
    }
}
