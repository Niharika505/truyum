package com.cognizant.truyum.service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;

@Component
public class CartService {

		@Autowired
		CartDaoCollectionImpl cartDaoCollectionImpl;
		@Autowired
		UserRepository userRepository;
		@Autowired
		MenuItemRepository menuItemRepository;
		public CartService(){
			
		}
		@Transactional
		public void addCartItem(String user,long menuItemId) throws ParseException{
			User userid= userRepository.findByUsername(user);
			MenuItem menuitem = menuItemRepository.findById(menuItemId);
			Set<MenuItem> cart=userid.getCartList();
			cart.add(menuitem);
			userRepository.save(userid);
		}
		@Transactional
		public Set<MenuItem> getAllCartItems(String userId){
			//return userRepository.getMenuItems(user);
			User user=userRepository.getMenuItems(userId);
			Set<MenuItem> menu=user.getCartList();
			
			return menu;
			
		}
		@Transactional
		public double getCartTotal(String userId)
		{
			double sum=0;
			User user=userRepository.getMenuItems(userId);
			Set<MenuItem> menu=user.getCartList();
			for(MenuItem menuItem:menu)
			{
				sum=sum+menuItem.getPrice();
			}
			return sum;
		}
		@Transactional
		public Set<MenuItem> deleteCartItems(String user,long menuItemId){
			//return cartDaoCollectionImpl.deleteCartItem(user, menuItemId);
			User userId=userRepository.getMenuItems(user);
			Set<MenuItem> menu=userId.getCartList();
			for(MenuItem menuItem:menu)
			{
				if(menuItem.getId()==menuItemId)
				{
					menu.remove(menuItem);
                    break;
				}
				
			}
			userRepository.save(userId);
			return menu;
		}
}
