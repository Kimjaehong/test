package com.issueking.test.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
//@RequestMapping(value="/")
public class HelloController {
    
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String welcomePage() {
	    
	    logger.debug("인덱스 페이지로 가자");

        return "index";

    }
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void loginPage() {
	    
	    logger.debug("login 페이지로 가자");
	}
	
}
