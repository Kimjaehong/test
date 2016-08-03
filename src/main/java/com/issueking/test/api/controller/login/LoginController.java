package com.issueking.test.api.controller.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/apis/login", method = RequestMethod.GET)
public class LoginController {
    /*private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @RequestMapping(value="/signin", method = RequestMethod.GET)
    public String signin(@RequestParam(value="error", required=false) String error, Model model) {

         model.addAttribute("error", error);

         // Sha 암호값을 보기 위한 테스트용.
         String guest_password = passwordEncoder.encode("guest");
         String admin_password = passwordEncoder.encode("admin");

         logger.info(guest_password + "//" + admin_password);

         return "signin";
    }

    @PreAuthorize("authenticated")
    @RequestMapping(value="/mypage", method = RequestMethod.GET)
    public String mypage(Model model) {

         Authentication auth = SecurityContextHolder.getContext().getAuthentication();
         model.addAttribute("user_name", auth.getName());

         return "mypage";
    }


    @RequestMapping(value="/denied", method = RequestMethod.GET)
    public String denied() {
         return "denied";
    }*/
}
