package com.cognizant.truyum.service;


import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.RoleRepository;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUser;
@Service
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	 UserRepository  userRepository;
	@Autowired
	RoleRepository  roleRepository  ;
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user= userRepository.findByUsername(username);
		AppUser app;
	
				if(user.getUsername()==null)
					{
					throw new  UsernameNotFoundException("Exception");
					}
					else
					{
						 app= new  AppUser(user);
						 System.out.println("gfjmvc"+app);
						 return app;
					}
		
	}
	@Transactional
	public void signup(User user) throws UserAlreadyExistsException 
	{
		User username= userRepository.findByUsername(user.getUsername());
		
		if(username!=null)
		{
			throw new UserAlreadyExistsException();
		}
		else
		{
			Set<Role> roleList=new HashSet();
			roleList.add(roleRepository.findById(1).get());
			System.out.println("vzsdhkxbnm"+roleList);
			user.setRoleList(roleList);
			user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			
			 userRepository.save(user);
		}
	}
	
}
