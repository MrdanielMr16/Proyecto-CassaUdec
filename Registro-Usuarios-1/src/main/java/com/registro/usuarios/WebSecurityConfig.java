package com.registro.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	

	AuthenticationSuccessHandler authenticationSuccessHandler;
	
	
	
	
	String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
	
	 protected void configure(HttpSecurity http) throws Exception {
	    	http
	        .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/","/index","/signup").permitAll()
	        
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .defaultSuccessUrl("/success", true)
	            .failureUrl("/login?error=true")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .and()
	            .csrf().disable()
	        .logout()
	            .permitAll()
	            .logoutSuccessUrl("/login?logout");
	    }
	
	
	 	BCryptPasswordEncoder bCryptPasswordEncoder;

	    public BCryptPasswordEncoder passwordEncoder() {
			bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
	        return bCryptPasswordEncoder;
	    }
	    
	    @Autowired
	    @Lazy
	    UserDetailsService userDetailsService;
	    
	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
	    	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    	 auth
             .inMemoryAuthentication()
             .withUser("user").password("{noop}pass").roles("USER")
             .and()
             .withUser("admin").password("{noop}pass").roles("ADMIN");
	    }
}
