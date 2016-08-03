package com.issueking.test.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.issueking.test.api.bean.user.CustomUserDetails;

@Controller
public class HelloController {
    
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	 
        @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage() {
	        return "application/login/index";
	    }
	     
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage() {
	        return "dba";
	    }
	 
	    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	    public String accessDeniedPage() {
	        return "login/denied";
	    }
	 
	    @RequestMapping(value = {"/login/signin"}, method = RequestMethod.GET)
	    public String loginPage() {
	        return "application/login/signin";
	    }
	    
	    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
        public String signupPage() {
            return "application/login/signup";
        }
	    
	    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
        public String mainPage() {
            return "application/index";
        }
	
}
