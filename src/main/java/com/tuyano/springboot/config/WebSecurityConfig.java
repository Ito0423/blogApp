package com.tuyano.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
          .authorizeRequests()
               .antMatchers("/","/home","/login","/signup").permitAll()
               .antMatchers("/webjars/**").permitAll()
               .antMatchers("/css/**").permitAll()
               .antMatchers("/img/**").permitAll()
                .anyRequest().authenticated()
                .and();
        http
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/manage",true)
        .and();
        http
              .logout()
                .permitAll();
       http.csrf().disable();
    }
 
 
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER");
    }
}