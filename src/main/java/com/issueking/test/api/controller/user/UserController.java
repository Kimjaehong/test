package com.issueking.test.api.controller.user;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.issueking.test.api.service.user.UserService;


@RestController
@RequestMapping("/apis/user")
public class UserController {
    
    @Inject
    private UserService userService;
    
    @RequestMapping(value = "/login")
    public Object userLogin(@RequestParam(value="userId", required = false) String userId,
                        @RequestParam(value="userPwd", required = false) String userPwd) throws Exception{
        
        return userService.processUserLogin(userId, userPwd);
    }
	
    
	
}
