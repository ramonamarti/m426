package gruppe3.todoliste.service;

import gruppe3.todoliste.model.List;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.ListRepository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * service to add a module, get a module with its id or remove a module
 */
@Service
public class ListService {
    private final ListRepository listRepository;

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

    /**
     * to delete a module from the table module
     * @param id: id of a module
     */
    public void removeList(Long id){
        if(id != null){
            Optional<List> optionalList = listRepository.findById(id);
            if(optionalList.isPresent())
                listRepository.deleteById(Math.toIntExact(id));
        }
    }
}
