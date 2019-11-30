package gruppe3.todoliste.service;

import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.repos.LoginRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/***
 * service to add a student, get a student with its login name, get a student with its id or remove a student
 */
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * to add and save a student in the table student
     * @param l : student to save
     */
    public void addLogin(@Valid Login l){
        loginRepository.saveAndFlush(l);
    }

    /**
     * to get a student form the table student with an id
     * @param id: id of a student
     * @return student with the correct id name from the table student
     */
    public Login getLogin(Long id){
        Login login = new Login();
        if(id != null){
            Optional<Login> optionalPerson = loginRepository.findById(id);
            if(optionalPerson.isPresent())
                login = optionalPerson.get();
        }
        return login;
    }

    /**
     * to get a student form the table student with a username
     * @param username: id of a student
     * @return student with the correct id name from the table student
     */
    public Login getLogin(String username){
        Login login = new Login();
        if(username != null){
            Optional<Login> optionalPerson = loginRepository.findByUsername(username);
            if(optionalPerson.isPresent())
                login = optionalPerson.get();
        }
        return login;
    }

    /**
     * to delete a student from the table student
     * @param id: id of a student
     */
    public void removeLogin(Long id){
        if(id != null){
            Optional<Login> optionalPerson = loginRepository.findById(id);
            if(optionalPerson.isPresent()) {
                loginRepository.deleteById(Math.toIntExact(id));
            }
        }
    }

    /**
     * to get a login of all students from the table student
     * @return login of all students of the table student
     */
    // not used jet
    public List<Login> findPerson(){
        return loginRepository.findAll();
    }
}
