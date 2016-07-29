package com.issueking.test.api.dao.user;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.issueking.test.api.persistance.login.LoginMapper;
import com.issueking.test.api.service.user.CustomUserDetailsSevice;
import com.issueking.test.api.util.Role;

@Repository
public class UserDao {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsSevice.class);
    
//    @Inject
//    private SqlSession sqlSession;
//    public void setSqlSession(SqlSession sqlSession){
//        this.sqlSession=sqlSession;
//    }
    @Inject
    private SqlSessionFactory sqlSessionFactory;
    
    public User loadUserByUsername(final String username) {
        //User user = new User();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        logger.debug("!!!!!!!!!!!!!!!!!!!!!"+sqlSession);
        logger.debug("!!!!!!!!!!!!!!!!!!!!!"+sqlSession.getMapper(LoginMapper.class));
        User user = sqlSession.getMapper(LoginMapper.class).getUser(username);
        
        
        //user.setFirstName("firstName");
        //user.setLastName("lastName");
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        user.setAuthorities(roles);
        return user;
    }
}
