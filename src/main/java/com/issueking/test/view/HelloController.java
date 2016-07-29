package com.issueking.test.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
    
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	 /*@RequestMapping(value = { "/", "/login/signin" }, method = RequestMethod.GET)
	    public String homePage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "/login/signin";
	    }*/
	 
        @RequestMapping(value = "/admin", method = RequestMethod.GET)
	    public String adminPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        logger.debug("admin::::::::::::::::::::::::::"+model);
	        return "login/index";
	    }
	     
	    @RequestMapping(value = "/db", method = RequestMethod.GET)
	    public String dbaPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "dba";
	    }
	 
	    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	    public String accessDeniedPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
	        return "accessDenied";
	    }
	 
	    @RequestMapping(value = {"/", "/login/signin"}, method = RequestMethod.GET)
	    public String loginPage() {
	        return "login/signin";
	    }
	    
	    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
        public String indexPage(ModelMap model) {
	        model.addAttribute("user", getPrincipal());
            return "login/index";
        }
	  
	    private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	    }
	
}
