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
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        logger.debug("admin::::::::::::::::::::::::::"+model);
	        return "application/login/index";
	    }
	     
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "dba";
	    }
	 
	    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "login/denied";
	    }
	 
	    @RequestMapping(value = {"/", "/login/signin"}, method = RequestMethod.GET)
	    public String loginPage() {
	        return "application/login/signin";
	    }
	    
	    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
        public String signupPage() {
            return "application/login/signUp";
        }
	    
	    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
        public String indexPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        logger.debug("user::::::::::::::::::::::::::"+model);
            return "application/login/index";
        }
	  
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof CustomUserDetails) {
	            userName = ((CustomUserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	
}
