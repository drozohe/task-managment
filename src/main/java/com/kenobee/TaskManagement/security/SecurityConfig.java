
package com.kenobee.TaskManagement.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
        


/**
 *
 * @author drozohe
 */


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .antMatcher("/**").authorizeRequests()                
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    }
}
