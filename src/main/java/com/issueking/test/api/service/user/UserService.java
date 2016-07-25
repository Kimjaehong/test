package com.issueking.test.api.service.user;

import java.util.Map;

public interface UserService {
    
    public Map<String, String> processUserLogin(String userId, String userPwd);

}
