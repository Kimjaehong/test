package com.issueking.test.api.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.api.persistance.user.UserMapper;
import com.issueking.test.api.util.Role;

@Service("CustomUserDetailsSevice")
public class CustomUserDetailsSevice implements UserDetailsService {
   
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsSevice.class);
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    CustomUserDetails customUserDetails = userMapper.getUser(username);
    //CustomUserDetails customUserDetails = userMapper.getAuthority(username);
    
    logger.info("customUserDetails::::::::"+customUserDetails);
    
    customUserDetails.setUsername(customUserDetails.getUsername());
    logger.info("encoded pwd :::::"+new BCryptPasswordEncoder().encode(customUserDetails.getPassword()));
    customUserDetails.setPassword(new BCryptPasswordEncoder().encode(customUserDetails.getPassword()));
    
    String defaultAuthority = "Anonymous";
    
    Collection<Role> authorities = (Collection<Role>) userMapper.getAuthority(username);
    logger.debug("authorities::::::"+authorities);
    boolean flag = true;
    
    for (Role role : authorities) {
        if (role.getAuthority().equals(defaultAuthority)) {
            flag = false;
        }
    }
    if (flag) {
        Role role = new Role();
        role.setAuthority(defaultAuthority);
        authorities.add(role);
    }
   
    return customUserDetails;
    }
}