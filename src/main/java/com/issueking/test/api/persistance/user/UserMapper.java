package com.issueking.test.api.persistance.user;

import java.util.Collection;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.base.util.Role;

@Repository(value="UserMapper")
public interface UserMapper {
    
    //@Select("SELECT * FROM users WHERE username = #{username}")
    public CustomUserDetails getUser(String username);
    
    @Select("SELECT * FROM authorities WHERE username = #{username}")
    public  Collection<Role> getAuthority(String username);
    
    /*@Insert("INSERT INTO users(username, password, name, enable) VALUE(#{userInfo.userId}, #{userInfo.password}, #{userInfo.name}, #{userInfo.enable})")
    public Map<String, Object> insertUser(Map<String, Object> userInfo);
    
    @Insert("INSERT INTO authorities(username, authority) VALUE(#{username}, #{authority})")
    public String insertAuthorities(String username, String authority);*/
    
    @Insert("INSERT INTO users(username, password, name, enabled) VALUES ( #{username}, #{encodedPassword}, #{name}, #{enabled})")
    public int insertUser(@Param("username") String username, 
                             @Param("encodedPassword") String encodedPassword,
                             @Param("name") String name,
                             @Param("enabled") int enabled);
    
    @Insert("INSERT INTO authorities(username, privileges) VALUES(#{username}, #{authority})")
    public int insertAuthorities(@Param("username") String username,
                                @Param("authority") String authority);
}