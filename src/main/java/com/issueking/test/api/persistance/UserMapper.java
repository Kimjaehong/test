package com.issueking.test.api.persistance;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM user_mst")
    public List<Map<String, String>> processUserLogin(Map<String, String> map);
}