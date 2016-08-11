package com.issueking.test.base.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.issueking.test.api.bean.user.CustomUserDetails;
import com.issueking.test.api.service.user.CustomUserDetailsSevice;

@Component
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    
    private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Autowired
    CustomUserDetailsSevice customUserDetailsSevice;
    
    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException {
        
        CustomUserDetails customUserDetails = (CustomUserDetails) customUserDetailsSevice.loadUserByUsername(authentication.getName());
        
        //사용자정보
        request.getSession().setAttribute("userId", customUserDetails.getUsername());
        request.getSession().setAttribute("userName", customUserDetails.getName());
        request.getSession().setAttribute("roles", authentication.getAuthorities());
        
        //메뉴정보
        //session.setAttribute(CommonConstant.ADMIN_SESSION_KEY_MENU, userInfo.get("menu_list");
        
        String targetUrl = determineTargetUrl(authentication);
        
        if (response.isCommitted()) {
            System.out.println("Can't redirect");
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
 
    /*
     * This method extracts the roles of currently logged-in user and returns
     * appropriate URL according to his/her role.
     */
    protected String determineTargetUrl(Authentication authentication) {
        String url = "";
 
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
 
        List<String> roles = new ArrayList<String>();
 
        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }
        
        logger.debug("CustomLoginSuccessHandler roles:::"+roles);
 
        /*if (isDba(roles)) {
            url = "/db";
        } else if (isAdmin(roles)) {
            url = "/admin";
        } else*/
        if (isUser(roles) || isAdmin(roles)) {
            url = "/index";
        } else {
            url = "/accessDenied";
        }
 
        return url;
    }
 
    private boolean isUser(List<String> roles) {
        if (roles.contains("ROLE_USER")) {
            return true;
        }
        return false;
    }
 
    private boolean isAdmin(List<String> roles) {
        if (roles.contains("ROLE_ADMIN")) {
            return true;
        }
        return false;
    }
 
    private boolean isDba(List<String> roles) {
        if (roles.contains("ROLE_DBA")) {
            return true;
        }
        return false;
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
 
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }
}
