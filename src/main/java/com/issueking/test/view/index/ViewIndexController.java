package com.issueking.test.view.index;

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
public class ViewIndexController {
    
	private static final Logger logger = LoggerFactory.getLogger(ViewIndexController.class);
	 
    	@RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    	public String indexPage() {
    	    return "application/index";
    	}
    	
	    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	    public String accessDeniedPage() {
	        return "login/denied";
	    }
	    
	
}
