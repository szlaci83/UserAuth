/*package me.laszloszoboszlai.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by laci on 03/07/2017.
 */
/*
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
            httpSecurity.authorizeRequests()
                    .antMatchers("/*").hasRole("USER")
                    .and()
                    .formLogin();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth){
        auth.jdbcAuthentication();
    }



}
*/