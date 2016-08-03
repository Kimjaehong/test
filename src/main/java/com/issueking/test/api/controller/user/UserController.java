package com.issueking.test.api.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.issueking.test.api.service.user.UserService;
import com.issueking.test.view.HelloController;

@Controller
@RequestMapping("apis/user")
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String insertUser(@RequestParam("userId") String userId, 
                            @RequestParam("userName") String name, 
                            @RequestParam("password") String password)  throws Exception {
               
        userService.insertUser(userId, name, password);
        
        return "/application/index";
    }
}
