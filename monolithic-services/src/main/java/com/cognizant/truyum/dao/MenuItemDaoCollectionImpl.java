package com.cognizant.truyum.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.MenuItems;

@Component
public class MenuItemDaoCollectionImpl {
	
	List<MenuItem> menuList= null;
	ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	MenuItems item = (MenuItems) context.getBean("menuitem");
	
	public MenuItemDaoCollectionImpl() {
		// TODO Auto-generated constructor stub
		this.menuList = item.getMenuList();
	}
	
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		List<MenuItem> menuListCustomer= new ArrayList<>();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		for(MenuItem menu : menuList){
			if(menu.isActive() && menu.getDateOfLaunch().before(date)){
				menuListCustomer.add(menu);
			}
		}
		return menuListCustomer;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		for(MenuItem menu : menuList){
			System.out.println(menu.getDateOfLaunch());
		}
		return menuList;
	}

	public MenuItem getMenuItem(long id) {
		// TODO Auto-generated method stub
		for(MenuItem menu : menuList){
			if(menu.getId() == id){
				return menu;
			}
		}
		return null;
	}

	public void modifyMenuItem(MenuItem menu) {
		// TODO Auto-generated method stub
		System.out.println(menu);
		int index=0;
		for(MenuItem menuItem : menuList){
			if(menuItem.getId() == menu.getId()){
				menuList.set(index,menu);
			}
			index++;
		}
	}

	
}
