package gruppe3.todoliste.service;

import org.springframework.stereotype.Service;
//import gruppe3.todoliste.repos.ListRespository;

import javax.validation.Valid;
import java.util.Optional;

/***
 * service to add a module, get a module with its id or remove a module
 */
@Service
public class ListService {
//    private final ListRespository listRespository;
//
//    public ListService(ListRespository listRespository) {
//        this.listRespository = listRespository;
//    }

//    /**
//     * to add and save a module in the table module
//     * @param m: module to save
//     * @return id of the entry
//     */
//    public Long addModule(@Valid Module m){
//        return moduleRespository.saveAndFlush(m).getId();
//    }
//
//    /**
//     * to get a module form the table module with a id
//     * @param id: id of a module
//     * @return module with the correct id from the table module
//     */
//    public Module getModule(Long id){
//        Module module = new Module();
//        if(id != null){
//            Optional<Module> optionalModule = moduleRespository.findById(id);
//            if(optionalModule.isPresent())
//                module = optionalModule.get();
//        }
//        return module;
//    }
//
//    /**
//     * to delete a module from the table module
//     * @param id: id of a module
//     */
//    public void removeModule(Long id){
//        if(id != null){
//            Optional<Module> optionalModule = moduleRespository.findById(id);
//            if(optionalModule.isPresent())
//                moduleRespository.deleteById(Math.toIntExact(id));
//        }
//    }
}
