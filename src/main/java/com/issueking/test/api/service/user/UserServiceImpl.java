package com.issueking.test.api.service.user;

import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.issueking.test.api.persistance.user.UserMapper;

import net.sf.json.JSONArray;

@Service
public class UserServiceImpl implements UserService{
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Inject
    private UserMapper userMapper;
    
    public Map<String, String> processUserLogin(String userId, String userPwd) {
        
       // System.out.println(JSONArray.fromObject(userMapper.processUserLogin(String userId, String userPwd)).toString(4));
        JSONArray.fromObject(userMapper.processUserLogin(userId, userPwd));
        
        return userMapper.processUserLogin(userId, userPwd); 
        
    }
    
}
