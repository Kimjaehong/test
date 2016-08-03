package com.issueking.test.api.service.user;

import java.util.Map;

public interface UserService {

    public void insertUser(String userId, String name, String encodedPassword) throws Exception;

}
