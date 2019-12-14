package gruppe3.todoliste.service;

import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.repos.LoginRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/***
 * service to add a login, get a login with its login name, get a login with its id or remove a login
 */
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * to add and save a login in the table login
     * @param l : login to save
     */
    public void addLogin(@Valid Login l){
        loginRepository.saveAndFlush(l);
    }

    /**
     * to get a login form the table login with an id
     * @param id: id of a login
     * @return login with the correct id name from the table login
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
     * to get all Logins from the table login
     * @return all with the correct id name from the table login
     */
    public java.util.List<Login> getAllLogins(){
        return loginRepository.findAll();
    }

    /**
     * to get a login from the table login with a username
     * @param username: id of a login
     * @return login with the correct id name from the table login
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
     * to delete a login from the table login
     * @param id: id of a login
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
     * to get a login of all logins from the table login
     * @return login of all logins of the table login
     */
    // not used jet
    public List<Login> findPerson(){
        return loginRepository.findAll();
    }
}
