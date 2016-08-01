package com.issueking.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.issueking.test.api.service.user.CustomUserDetailsSevice;
import com.issueking.test.api.util.CustomAuthenticationProvider;
import com.issueking.test.api.util.CustomLoginSuccessHandler;
import com.issueking.test.api.util.CustomLogoutHandler;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.issueking.test")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    DataSource dataSource;
        
    @Bean
    public CustomLoginSuccessHandler customLoginSuccessHandler() {
        return  new CustomLoginSuccessHandler();
    }
    
    @Bean
    public CustomLogoutHandler customLogoutHandler() {
        return new CustomLogoutHandler();
    }
    
    @Bean
    public CustomUserDetailsSevice customUserDetailsSevice() {
        return new CustomUserDetailsSevice();
    }
    
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider();
    }
     
    //Spring Security ignores request to static resources such as CSS or JS files.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
            .ignoring()
            .antMatchers("/resources/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/login/signin").permitAll()
            .antMatchers("/index/**").hasAnyRole("USER")
            //.antMatchers("/login/signin").hasAnyRole("ANONYMOUS")
            .antMatchers("/**").hasAnyRole("ANONYMOUS", "USER", "ADMIN")
            /*.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")*/
        .and()
            .formLogin()
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginPage("/login/signin")
                .loginProcessingUrl("/loginProcess")
                //.defaultSuccessUrl("/index", true)
                .failureUrl("/login/signin?fail=true")
                .successHandler(customLoginSuccessHandler())
        .and()
            .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(customLogoutHandler());
                //.invalidateHttpSession(true)                                             
                //.logoutSuccessUrl("/login/signin")
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .authenticationProvider(customAuthenticationProvider())
        .userDetailsService(customUserDetailsSevice());
            /*.jdbcAuthentication()
            .dataSource(dataSource);*/
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
    /*@Bean
    public ReflectionSaltSource saltSource() {
        return new ReflectionSaltSource();
    }*/
}
