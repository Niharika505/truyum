package com.cognizant.menuitemservice.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.model.User;
import com.cognizant.menuitemservice.model.Users;
import com.cognizant.menuitemservice.service.AppUserDetailsService;
import com.cognizant.menuitemservice.service.UserService;




@RestController
@CrossOrigin
@Component
public class UserController {
	
	@Autowired
	AppUserDetailsService appUserDetailsService; 
    @PostMapping("/users")
    public String signup(@RequestBody Users userlist) {
                    return appUserDetailsService.signup(userlist);
    }

	
	
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	
	
	 @Autowired
	    UserService userService;
	 
	
	   @GetMapping("/user/{name}")
    public User findByUsername(@PathVariable String name) {
           return userService.findByUsername(name);
           
    }
	   @GetMapping("/users/{name}")
	     public UserDetails loadUserByUsername(@PathVariable String name) {
	          
	           return appUserDetailsService.loadUserByUsername(name);
	     }
	     
}
