package com.july.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeRequests()
	                .antMatchers(HttpMethod.GET, "/student/get/**").authenticated()
	                .antMatchers(HttpMethod.POST, "/student/save").authenticated()
	                .anyRequest().permitAll()
	                .and()
	                .httpBasic();

	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	            .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
	           
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	
	
}