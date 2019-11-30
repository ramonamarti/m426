package gruppe3.todoliste.service;

import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.repos.LoginRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/***
 * service to add a person, get a person with its login name, get a person with its id or remove a person
 */
@Service
public class LoginService {
    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    /**
     * to add and save a person in the table person
     * @param l : person to save
     */
    public void addLogin(@Valid Login l){
        loginRepository.saveAndFlush(l);
    }

    /**
     * to get a person form the table person with an id
     * @param id: id of a person
     * @return person with the correct id name from the table person
     */
    public Login getLogin(Long id){
        Login login = new Login();
        if(id != null){
            Optional<Login> optionalLogin = loginRepository.findById(id);
            if(optionalLogin.isPresent())
                login = optionalLogin.get();
        }
        return login;
    }

    /**
     * to get a person form the table person with a username
     * @param username: id of a person
     * @return person with the correct id name from the table person
     */
    public Login getLogin(String username){
        Login login = new Login();
        if(username != null){
            Optional<Login> optionalLogin = loginRepository.findByUsername(username);
            if(optionalLogin.isPresent())
                login = optionalLogin.get();
        }
        return login;
    }

    /**
     * to delete a person from the table person
     * @param id: id of a person
     */
    public void removeLogin(Long id){
        if(id != null){
            Optional<Login> optionalLogin = loginRepository.findById(id);
            if(optionalLogin.isPresent()) {
                loginRepository.deleteById(Math.toIntExact(id));
            }
        }
    }

    /**
     * to get a login of all persons from the table person
     * @return login of all persons of the table person
     */
    // not used jet
    public List<Login> findLogin(){
        return loginRepository.findAll();
    }
}
