package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Component
public class MenuItemService {

	@Autowired
	MenuItemDaoCollectionImpl dao;
	@Autowired
	MenuItemRepository menuItemRepository;
	public MenuItemService() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		return menuItemRepository.getMenuItemListCustomer();
	}
	
    
	 @Transactional 
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		List<MenuItem> menuitems = new ArrayList<>();  
		menuitems=(List<MenuItem>) menuItemRepository.findAll();
		return menuitems;
	}
	 @Transactional
	public MenuItem getMenuItem(long id) {
		// TODO Auto-generated method stub
		return menuItemRepository.findById(id);
	}
	 @Transactional
	public void modifyMenuItem(MenuItem menu) {
		// TODO Auto-generated method stub
		menuItemRepository.save(menu);
	}

}
