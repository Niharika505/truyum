package com.cognizant.menuitemservice.service;


import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.menuitemservice.SecurityConfig;
import com.cognizant.menuitemservice.model.Role;
import com.cognizant.menuitemservice.model.User;
import com.cognizant.menuitemservice.model.Users;
import com.cognizant.menuitemservice.repository.RoleRepository;
import com.cognizant.menuitemservice.repository.UserRepository;
import com.cognizant.menuitemservice.security.AppUser;


@Service
public class AppUserDetailsService implements UserDetailsService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
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
	/*@Transactional
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
	*/
	
	public String signup(@RequestBody Users userlist) {
        LOGGER.info(userlist.getUsername());
        User users = userRepository.findByUsername(userlist.getUsername());
        if (users == null) {
                        User user = new User();
                        user.setUsername(userlist.getUsername());
                        user.setPassword(passwordEncoder().encode(userlist.getPassword()));
                        Role role = roleRepository.findByName("user");
                        Set<Role> roles = new HashSet<>();
                        roles.add(role);
                        user.setRoleList(roles);
                        userRepository.save(user);
                        return "true";
        }
        return "false";
}

@Bean
public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
}

}
