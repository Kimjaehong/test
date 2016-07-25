package com.issueking.test.api.persistance.user;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT user_id, user_pwd FROM user_mst WHERE user_id = #{userId} and user_pwd = #{userPwd}")
    public Map<String, String> processUserLogin(@Param("userId") String userId, @Param("userPwd") String userPwd);
}