package com.issueking.test.api.persistance.user;

import java.util.Collection;

import org.apache.ibatis.annotations.Select;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.api.util.Role;

public interface UserMapper {
    
    @Select("SELECT * FROM users WHERE username = #{username}")
    public CustomUserDetails getUser(String username);
    
    @Select("SELECT * FROM authorities WHERE username = #{username}")
    public Collection<Role> getAuthority(String username);
}