package com.issueking.test.view.main;

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
@RequestMapping(value = "view/main")
public class ViewMainController {
    
	private static final Logger logger = LoggerFactory.getLogger(ViewMainController.class);
	 
    @RequestMapping(value = "/loginRD", method = RequestMethod.GET)
    public String loginPage() {
        return "application/common/loginRD";
    }
    
    @RequestMapping(value = "/signupRD", method = RequestMethod.GET)
    public String signupPage() {
        return "application/common/signupRD";
    }
    
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainPage() {
        return "application/main/main";
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testPage() {
        return "application/main/test";
    }
}
