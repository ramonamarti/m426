package gruppe3.todoliste.service;

//import gruppe3.todoliste.repos.LoginRespository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

/***
 * service to add a student, get a student with its login name, get a student with its id or remove a student
 */
@Service
public class LoginService {
//    private final LoginRespository loginRespository;
//
//    public LoginService(LoginRespository loginRespository) {
//        this.loginRespository = loginRespository;
//    }

//    /**
//     * to add and save a student in the table student
//     * @param l: student to save
//     * @return id of the entry
//     */
//    public Long addLogin(@Valid Login l){
//        return loginRespository.saveAndFlush(l).getId();
//    }
//
//    /**
//     * to get a student form the table student with an id
//     * @param id: id of a student
//     * @return student with the correct id name from the table student
//     */
//    public Login getLogin(Long id){
//        Login login = new Login();
//        if(id != null){
//            Optional<Login> optionalStudent = loginRespository.findById(id);
//            if(optionalStudent.isPresent())
//                login = optionalStudent.get();
//        }
//        return login;
//    }
//
//    /**
//     * to get a student form the table student with a loginname
//     * @param id: id of a student
//     * @return student with the correct id name from the table student
//     */
//    public Login getLogin(String loginname){
//        Login login = new Login();
//        if(loginname != null){
//            Optional<Login> optionalStudent = loginRespository.findById(loginname);
//            if(optionalStudent.isPresent())
//                login = optionalStudent.get();
//        }
//        return login;
//    }
//
//    /**
//     * to delete a student from the table student
//     * @param id: id of a student
//     */
//    public void removeLogin(Long id){
//        if(id != null){
//            Optional<Login> optionalStudent = loginRespository.findById(id);
//            if(optionalStudent.isPresent()) {
//                loginRespository.deleteById(Math.toIntExact(id));
//            }
//        }
//    }
//
//    /**
//     * to get a list of all students from the table student
//     * @return list of all students of the table student
//     */
//    // not used jet
//    public List<Login> findStudent(){
//        return loginRespository.findAll();
//    }
}
