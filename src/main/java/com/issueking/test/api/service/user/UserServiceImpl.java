package com.issueking.test.api.service.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.issueking.test.api.persistance.user.UserMapper;
import com.issueking.test.view.HelloController;

@Component
@Service("UserService")
public class UserServiceImpl implements UserService {
    
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired 
    BCryptPasswordEncoder passwordEncoder;
    
    /*@Autowired
    ReflectionSaltSource saltSource;*/
    
    @Autowired
    UserMapper userMapper;
    
    /*public void insertUser(Map<String, Object> paramMap) throws Exception {
        
        Boolean enable = true;
        paramMap.put("enable", enable);
        userMapper.insertUser(paramMap);
        
        String userId = (String) paramMap.get("userId");
        String authority = "Role_User";
        userMapper.insertAuthorities(userId, authority);
        
    }*/
    public void insertUser(String userId, String name, String password) throws Exception {
        int enabled = 1;
        String encodedPassword = passwordEncoder.encode(password);
        logger.info("userId::::::::::::::::::::::::::"+userId);
        logger.info("encodedPassword::::::::::::::::::::::::::"+encodedPassword);
        userMapper.insertUser(userId, encodedPassword, name, enabled);
        
        String authority = "Role_User";
        userMapper.insertAuthorities(userId, authority);
    }
}
