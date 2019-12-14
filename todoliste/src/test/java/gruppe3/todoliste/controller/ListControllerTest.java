package gruppe3.todoliste.controller;

import gruppe3.todoliste.service.ListService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
class ListControllerTest {

    @Mock
    private ListService listService;

    @InjectMocks
    private ListController listController = new ListController(listService);

    @Test
    void todo() {
        Assert.assertNotNull(listController);
    }
}