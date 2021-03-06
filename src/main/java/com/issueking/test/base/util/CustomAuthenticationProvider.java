package com.issueking.test.base.util;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.api.service.user.CustomUserDetailsSevice;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
    
    @Autowired
    private CustomUserDetailsSevice customUserDetailsSevice;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        String username = (String)authentication.getPrincipal(); 
        //String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        //Collection<? extends GrantedAuthority> authorities;

            CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsSevice.loadUserByUsername(username);
            
            if (!passwordEncoder.matches(password, customUserDetails.getPassword())) {
                throw new BadCredentialsException("비밀번호 불일치");
            }
           // authorities = customUserDetails.getAuthorities();
            
            return new UsernamePasswordAuthenticationToken(username, password, customUserDetails.getAuthorities());
 
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
