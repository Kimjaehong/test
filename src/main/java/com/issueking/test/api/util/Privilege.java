package com.issueking.test.api.util;

public class Privilege {
    
    private String privileges;
    
    
   /* public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }*/
 
    public String getPrivileges() {
        return privileges;
    }


    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Privilege [name=");
        builder.append(privileges);
        builder.append("]");
        return builder.toString();
    }
}
