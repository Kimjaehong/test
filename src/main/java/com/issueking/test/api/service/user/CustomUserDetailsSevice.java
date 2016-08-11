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
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.api.persistance.user.UserMapper;
import com.issueking.test.base.util.Role;


@Service("CustomUserDetailsSevice")
public class CustomUserDetailsSevice implements UserDetailsService {
   
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsSevice.class);
    
    @Autowired
    UserMapper userMapper;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    CustomUserDetails customUserDetails = userMapper.getUser(username);
    
    Collection<Role> roles = userMapper.getAuthority(username);
    for (Role role : roles) {
        List<Role> userRoles = new ArrayList<Role>();
        userRoles.add(role);
        customUserDetails.setAuthorities(userRoles);
    }
    
    if(customUserDetails==null) throw new UsernameNotFoundException("["+username+"] 으로 검색된 결과가 없습니다");
    if(customUserDetails.getAuthorities().size()==0) 
        throw new UsernameNotFoundException("["+username+"] 이용자는 권한이 없습니다");
    
    return customUserDetails;
    }
}