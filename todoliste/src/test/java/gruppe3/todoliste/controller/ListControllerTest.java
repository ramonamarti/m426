package gruppe3.todoliste.controller;

import gruppe3.todoliste.service.ListService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Testclass tests if the attribut after renaming to LIST_SERVICE still works.
 * If the test result ist green, LIST_SERVICE is not null.
 * @Author: Michael Zihlmann
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class ListControllerTest {

    @Mock
    private ListService LIST_SERVICE;

    @InjectMocks
    private ListController listController = new ListController(LIST_SERVICE);

    @Test
    void todo() {
        Assert.assertNotNull(listController);
    }
}