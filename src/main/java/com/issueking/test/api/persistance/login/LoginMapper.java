package com.issueking.test.api.persistance.login;

import org.apache.ibatis.annotations.Select;

import com.issueking.test.api.dao.Member;
import com.issueking.test.api.dao.user.User;

public interface LoginMapper {
    @Select("SELECT * FROM users WHERE username = #{username}")
    public User getUser(String username);
}
