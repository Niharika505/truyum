package com.cognizant.menuitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.menuitemservice.model.MenuItem;
import com.cognizant.menuitemservice.service.AppUserDetailsService;
import com.cognizant.menuitemservice.service.MenuItemService;


@RestController
@CrossOrigin
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemService menuItemService;
	@Autowired
	AppUserDetailsService appUserDetailsService; 
	
	@GetMapping("")
	public List<MenuItem> getAllMenuItems() {
		
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
				String user = authentication.getName();
				UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
				String roleType = userDetails.getAuthorities().toArray()[0].toString();
				if(!roleType.equals("admin")){
					return menuItemService.getMenuItemListCustomer();
				}
				else{
					return menuItemService.getMenuItemListAdmin(); 
				}
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") int id) {
			return menuItemService.getMenuItem(id);
	}
	
	@PutMapping("")
	public void modifyMenuItem(@RequestBody MenuItem menu) {
		menuItemService.modifyMenuItem(menu); 	
	}
	
	
}
