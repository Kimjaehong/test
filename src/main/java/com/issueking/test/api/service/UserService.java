package com.issueking.test.api.service;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.issueking.test.api.persistance.UserMapper;

import net.sf.json.JSONArray;

@Service
public class UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    
    @Inject
    private UserMapper userDao;
    
    public String processUserLogin(Map<String, String> map) {
        
        System.out.println(JSONArray.fromObject(userDao.processUserLogin(map)).toString(4));
        
        return null;
    }
    
    

}
