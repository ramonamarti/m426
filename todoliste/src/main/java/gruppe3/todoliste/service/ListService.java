package gruppe3.todoliste.service;

import gruppe3.todoliste.model.List;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.ListRepository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * dashboard to show all entries
 * Author: Michi
 */
@Service
public class ListService {
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    /**
     * to add and save a entry
     * @param l: entry to save
     * @return id of the entry
     */
    public Long addList(@Valid List l){
        return listRepository.saveAndFlush(l).getId();
    }

    /**
     * get a entry with a id
     * @param id: id of a entry
     * @return entry with the correct id
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
     * to delete a entry
     * @param id: id of a entry
     */
    public void removeList(Long id){
        if(id != null){
            Optional<List> optionalList = listRepository.findById(id);
            if(optionalList.isPresent())
                listRepository.deleteById(Math.toIntExact(id));
        }
    }
}
