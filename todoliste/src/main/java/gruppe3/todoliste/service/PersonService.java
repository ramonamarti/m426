package gruppe3.todoliste.service;

import gruppe3.todoliste.model.Person;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.PersonRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/***
 * service to add a person, get a person with its login name, get a person with its id or remove a person
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * to add and save a person in the table person
     * @param p : person to save
     */
    public void addPerson(@Valid Person p){
        personRepository.saveAndFlush(p);
    }

//    /**
//     * to get a person form the table person with a login name
//     * @param login: login of a person
//     * @return person with the correct login name from the table person
//     */
//    public Person getPerson(String login){
//        Person person = new Person();
//        if(login != null){
//            Optional<Person> optionalPerson = personRepository.findByLogin(login);
//            if(optionalPerson.isPresent())
//                person = optionalPerson.get();
//        }
//        return person;
//    }

    /**
     * to get a person form the table person with an id
     * @param id: id of a person
     * @return person with the correct id name from the table person
     */
    public Person getPerson(Long id){
        Person person = new Person();
        if(id != null){
            Optional<Person> optionalPerson = personRepository.findById(id);
            if(optionalPerson.isPresent())
                person = optionalPerson.get();
        }
        return person;
    }

    /**
     * to delete a person from the table person
     * @param id: id of a person
     */
    public void removePerson(Long id){
        if(id != null){
            Optional<Person> optionalPerson = personRepository.findById(id);
            if(optionalPerson.isPresent()) {
                personRepository.deleteById(Math.toIntExact(id));
            }
        }
    }

    /**
     * to get a list of all persons from the table person
     * @return list of all persons of the table person
     */
    // not used jet
    public List<Person> findPerson(){
        return personRepository.findAll();
    }
}
