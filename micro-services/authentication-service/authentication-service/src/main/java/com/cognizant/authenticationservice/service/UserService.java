package com.cognizant.authenticationservice.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authenticationservice.model.User;
import com.cognizant.authenticationservice.repository.UserRepository;




@Service
public class UserService {
	@Autowired
	   UserRepository userRepository;
	  @Transactional
	   public User findByUsername(String name)
	   {
		   return userRepository.findByUsername(name);
	   }
	
}
