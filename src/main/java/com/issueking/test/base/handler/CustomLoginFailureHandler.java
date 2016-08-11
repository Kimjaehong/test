package com.issueking.test.base.handler;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler implements AuthenticationFailureHandler{
    
    private static final Logger logger = LoggerFactory.getLogger(CustomLoginFailureHandler.class);
        
    String exceptionMessage = "아이디 비밀번호 확인";
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
            HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        
        logger.debug("exception:::::::::::::"+exception.toString());
        logger.debug("exception:::::::::::::"+exception.getMessage());
        if (exception instanceof BadCredentialsException){
            response.sendError(403, exceptionMessage);
        }
        //response.sendError(403, exception.getMessage());
        //throw exception;
    }
}
