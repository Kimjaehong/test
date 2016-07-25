package com.issueking.test.api.controller;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.issueking.test.api.service.UserService;


@RestController
@RequestMapping("/apis/user")
public class UserController {
    
    @Inject
    private UserService userService;
    
    @RequestMapping(value = "/login")
    public String userLogin(@RequestParam(value="id", required = false) String id ,
                        @RequestParam(value="pwd", required = false) String pwd) throws Exception{
        
        Map<String, String> map = new HashMap<>();
        
        map.put("id", id);
        map.put("pwd", pwd);
       
        return userService.processUserLogin(map);
       
    }
	
    
	
}
