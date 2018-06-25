package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
    	//	.passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("ramiro").password("{noop}banana").roles("USER")
                .and().withUser("admin").password("admin").roles("USER","ADMIN");;
    }
	
	  @Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
				.antMatchers("/students/**").hasAnyRole("USER")
				.antMatchers("/diciplines/**").hasAnyRole("MANAGER")
				.anyRequest().fullyAuthenticated()
				.and().httpBasic().and().csrf().disable(); 
		}
	
}
