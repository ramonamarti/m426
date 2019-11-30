package gruppe3.todoliste.service;

import gruppe3.todoliste.model.Person;
import org.springframework.stereotype.Service;
import gruppe3.todoliste.repos.PersonRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/***
 * service to add a student, get a student with its login name, get a student with its id or remove a student
 */
@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * to add and save a student in the table student
     * @param p : student to save
     */
    public void addPerson(@Valid Person p){
        personRepository.saveAndFlush(p);
    }

//    /**
//     * to get a student form the table student with a login name
//     * @param login: login of a student
//     * @return student with the correct login name from the table student
//     */
//    public Person getPerson(String login){
//        Person person = new Person();
//        if(login != null){
//            Optional<Person> optionalStudent = personRepository.findByLogin(login);
//            if(optionalStudent.isPresent())
//                person = optionalStudent.get();
//        }
//        return person;
//    }

    /**
     * to get a student form the table student with an id
     * @param id: id of a student
     * @return student with the correct id name from the table student
     */
    public Person getPerson(Long id){
        Person person = new Person();
        if(id != null){
            Optional<Person> optionalStudent = personRepository.findById(id);
            if(optionalStudent.isPresent())
                person = optionalStudent.get();
        }
        return person;
    }

    /**
     * to delete a student from the table student
     * @param id: id of a student
     */
    public void removePerson(Long id){
        if(id != null){
            Optional<Person> optionalStudent = personRepository.findById(id);
            if(optionalStudent.isPresent()) {
                personRepository.deleteById(Math.toIntExact(id));
            }
        }
    }

    /**
     * to get a list of all students from the table student
     * @return list of all students of the table student
     */
    // not used jet
    public List<Person> findStudent(){
        return personRepository.findAll();
    }
}
