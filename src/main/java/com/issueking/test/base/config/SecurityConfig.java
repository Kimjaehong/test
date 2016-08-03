package com.issueking.test.base.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.issueking.test.api.service.user.CustomUserDetailsSevice;
import com.issueking.test.base.util.CustomAccessDeniedHandler;
import com.issueking.test.base.util.CustomAuthenticationProvider;
import com.issueking.test.base.util.CustomLoginSuccessHandler;
import com.issueking.test.base.util.CustomLogoutHandler;

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
    
    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
     
    //Spring Security ignores request to static resources such as CSS or JS files.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/index/**").hasAnyRole("USER", "ADMIN")
            .antMatchers("/**").permitAll()
        .and()
            .formLogin()
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginPage("/login")
                .loginProcessingUrl("/loginProcess")
                .successHandler(customLoginSuccessHandler())
                //.defaultSuccessUrl("/index", true)
                .failureUrl("/login/signin?fail=true")
        .and()
            .logout()
                .logoutUrl("/logout")
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(customLogoutHandler())
        .and()
            .exceptionHandling()
            .accessDeniedHandler(customAccessDeniedHandler());
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        ReflectionSaltSource saltSource = new ReflectionSaltSource();
        saltSource.setUserPropertyToUse("username");
        
        auth
        .authenticationProvider(customAuthenticationProvider())
        .userDetailsService(customUserDetailsSevice()).passwordEncoder(passwordEncoder());
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
    
/*   @Bean
    public ReflectionSaltSource saltSource() {
        return new ReflectionSaltSource();
    }*/
}
