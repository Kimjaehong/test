import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.issueking.test.api.persistance.UserMapper;
import com.issueking.test.api.service.UserService;
import com.issueking.test.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestCode {
@Inject UserService service;
@Inject UserMapper dao;

        @Test
        public void testService() {
            Map<String, String> map = new HashMap<>();
            service.processUserLogin(map);
        }
}
