package com.issueking.test.api.service.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.issueking.test.api.dao.Member;
import com.issueking.test.api.persistance.login.LoginMapper;

@Service("CustomUserDetailsSevice")
public class CustomUserDetailsSevice implements UserDetailsService {
   
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsSevice.class);
    
    private SqlSession sqlSession;
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }
    
   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //System.out.println(sqlSession);
        Member ur=sqlSession.getMapper(LoginMapper.class).getUser(username);
        String password=ur.getPwd();
        List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
 
        String[]roles=ur.getRole().split(",");
        for(String role:roles){
            list.add(new SimpleGrantedAuthority(role));
        }
        UserDetails user=new User(username, password, list);
        return user;
    }*/
   
    
    
    /*@Override
    public UserDetailsVO loadUserByUsername(final String username) throws UsernameNotFoundException {

        logger.info("username : " + username);

        // 회원 정보 dao 에서 데이터를 읽어 옴.

        // test 값을 암호화함.
        String password = "aabcb987e4b425751e210413562e78f776de6285";

        UserDetailsVO user = new UserDetailsVO();
        user.setUsername(username);
        user.setPassword(password);

        Role role = new Role();
        role.setName("ROLE_USER");

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setAuthorities(roles);

        // 만약 데이터가 없을 경우 익셉션
        //if (user == null) throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");

        return user;
    }*/

}