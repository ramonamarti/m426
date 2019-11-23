package gruppe3.todoliste.service;

import org.springframework.stereotype.Service;
//import gruppe3.todoliste.repos.PersonRespository;

import javax.validation.Valid;
import java.util.List;

/***
 * service to add a student, get a student with its login name, get a student with its id or remove a student
 */
@Service
public class PersonService {
//    private final PersonRespository personRespository;
//
//    public PersonService(PersonRespository personRespository) {
//        this.personRespository = personRespository;
//    }

//    /**
//     * to add and save a student in the table student
//     * @param p: student to save
//     * @return id of the entry
//     */
//    public Long addPerson(@Valid Person p){
//        return personRespository.saveAndFlush(p).getId();
//    }
//
//    /**
//     * to get a student form the table student with a login name
//     * @param login: login of a student
//     * @return student with the correct login name from the table student
//     */
//    public Person getPerson(String login){
//        Person person = new Person();
//        if(login != null){
//            Optional<Person> optionalStudent = personRespository.findByLogin(login);
//            if(optionalStudent.isPresent())
//                person = optionalStudent.get();
//        }
//        return person;
//    }
//
//    /**
//     * to get a student form the table student with an id
//     * @param id: id of a student
//     * @return student with the correct id name from the table student
//     */
//    public Person getPerson(Long id){
//        Person person = new Person();
//        if(id != null){
//            Optional<Person> optionalStudent = personRespository.findById(id);
//            if(optionalStudent.isPresent())
//                person = optionalStudent.get();
//        }
//        return person;
//    }
//
//    /**
//     * to delete a student from the table student
//     * @param id: id of a student
//     */
//    public void removePerson(Long id){
//        if(id != null){
//            Optional<Person> optionalStudent = personRespository.findById(id);
//            if(optionalStudent.isPresent()) {
//                personRespository.deleteById(Math.toIntExact(id));
//            }
//        }
//    }
//
//    /**
//     * to get a list of all students from the table student
//     * @return list of all students of the table student
//     */
//    // not used jet
//    public List<Person> findStudent(){
//        return personRespository.findAll();
//    }
}