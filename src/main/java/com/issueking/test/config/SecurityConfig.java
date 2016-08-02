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
import com.issueking.test.api.util.CustomAccessDeniedHandler;
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
            //.antMatchers("/**").permitAll()
            .antMatchers("/**").hasAnyRole("ANONYMOUS","USER", "ADMIN")
            //.antMatchers("/admin/**").hasRole("ADMIN")
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
                .logoutSuccessHandler(customLogoutHandler())
                //.invalidateHttpSession(true)                                             
                //.logoutSuccessUrl("/login/signin")
                .and().exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .authenticationProvider(customAuthenticationProvider())
        .userDetailsService(customUserDetailsSevice());
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
