package gruppe3.todoliste;

import gruppe3.todoliste.controller.PersonController;
import gruppe3.todoliste.model.List;
import gruppe3.todoliste.model.Login;
import gruppe3.todoliste.model.Person;
import gruppe3.todoliste.repos.ListRepository;
import gruppe3.todoliste.repos.LoginRepository;
import gruppe3.todoliste.repos.PersonRepository;
import gruppe3.todoliste.service.ListService;
import gruppe3.todoliste.service.LoginService;
import gruppe3.todoliste.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import java.util.Enumeration;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class TodolisteApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Test
    public void contextLoads() {}

    @Test
    public void personSaveTest(){
        Person p = new Person("Ramona", "Marti");

        personRepository.saveAndFlush(p);

        assertNotNull(p.getId());
        assertNotNull(p.getFirstname());
        assertNotNull(p.getFamilyname());

    }

    @Test
    public void loginSaveTest(){
        Person p = new Person("Ramona", "Marti");
        Person p2 = new Person("Ramona", "Marti");
        Login l = new Login("admin","123123",p);
        Login l2 = new Login("admin","123123",p2);

        loginRepository.saveAndFlush(l);
        loginRepository.saveAndFlush(l2); // has to throw error constraint unique key (UK...)

        assertNotNull(l.getId());
        assertNotNull(l2.getId());

    }

    @Test
    public void listSaveTest(){
        Person p = new Person("Ramona", "Marti");
        List l = new List("2019-12-06", "Check status of Project",p);

        listRepository.saveAndFlush(l);

        assertNotNull(l.getId());

    }

}
