package com.issueking.test.api.util;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 1L;
    private String username;
    private String privileges;
 

 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getAuthority() {
        return this.privileges;
    }
 
    public String getPrivileges() {
        return privileges;
    }
 
    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
 
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Role [name=");
        builder.append(username);
        builder.append(", privileges=");
        builder.append(privileges);
        builder.append("]");
        return builder.toString();
    }

    public void setAuthority(String defaultAuthority) {
        // TODO Auto-generated method stub
        
    }

}
