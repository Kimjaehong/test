package com.issueking.test.api.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.issueking.test.api.persistance.user.UserMapper;

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
    
    public void insertUser(String userId, String name, String password) throws Exception {
        
        int enabled = 1;
        String encodedPassword = passwordEncoder.encode(password);
        userMapper.insertUser(userId, encodedPassword, name, enabled);
        
        String authority = "ROLE_USER";
        userMapper.insertAuthorities(userId, authority);
    }
}
