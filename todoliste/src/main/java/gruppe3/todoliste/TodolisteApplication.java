package gruppe3.todoliste;

import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootApplication
public class TodolisteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodolisteApplication.class, args);
    }

}
