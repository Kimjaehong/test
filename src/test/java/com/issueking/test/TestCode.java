package com.issueking.test;
import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.issueking.test.api.controller.user.UserController;
import com.issueking.test.api.persistance.user.UserMapper;
import com.issueking.test.api.service.user.UserServiceImpl;
import com.issueking.test.base.config.WebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class TestCode {
@Inject UserServiceImpl service;
@Inject UserMapper dao;
@Inject UserController userController;

        @Test
        public void testService() throws Exception {
           // Map<String, String> map = new HashMap<>();
           
            
           // userController.userLogin("kingjhong", "1234");
        }
}
