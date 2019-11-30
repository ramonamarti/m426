package gruppe3.todoliste.service;

import gruppe3.todoliste.model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.ListRespository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * service to add a module, get a module with its id or remove a module
 */
@Service
public class ListService {


    @Autowired
    private ListRespository listRespository;

    /**
     *
     * @param list ToDoEintrag welche hinzugefügt werden soll
     * @return ID von hinzugefügte Route
     */
    public Long addList(@Valid List list){
        listRespository.saveAndFlush(list);
        return list.getId();
    }

//    /**
//     * to add and save a module in the table module
//     * @param l: module to save
//     * @return id of the entry
//     */
//    public Long addList(@Valid List l){
//        return listRespository.saveAndFlush(l).getId();
//    }
//
//    /**
//     * to get a module form the table module with a id
//     * @param id: id of a module
//     * @return module with the correct id from the table module
//     */
//    public List getList(Long id){
//        List module = new List();
//        if(id != null){
//            Optional<List> optionalList = listRespository.findById(id);
//            if(optionalList.isPresent())
//                module = optionalList.get();
//        }
//        return module;

//    }
//
//    /**
//     * to delete a module from the table module
//     * @param id: id of a module
//     */
//    public void removeList(Long id){
//        if(id != null){
//            Optional<List> optionalList = listRespository.findById(id);
//            if(optionalList.isPresent())
//                listRespository.deleteById(Math.toIntExact(id));
//        }
//    }
}
