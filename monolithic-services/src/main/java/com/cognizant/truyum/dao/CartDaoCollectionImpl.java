package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.*;

@Component
public class CartDaoCollectionImpl implements CartDao {

	@Override
	public void addCartItem(String user, long menuItemId) throws ParseException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CartDTO getAllCartItems(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartDTO deleteCartItem(String user, long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*private static HashMap<String, CartDTO> userCarts = new HashMap<String, CartDTO>();

	List<MenuItem> menuList= null;
	ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	MenuItems item = (MenuItems) context.getBean("menuitem");
	
	public CartDaoCollectionImpl() throws ParseException {
		this.menuList = item.getMenuList();
		ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
		if (userCarts.isEmpty()) {
			CartDTO cart = new CartDTO(menuItem, 0);
			userCarts.put(null, cart);
		}
	}

	@Override
	public void addCartItem(String user, long menuItemId) throws ParseException {
		// TODO Auto-generated method stub
		MenuItem menuItem = new MenuItem();
			for(MenuItem menu : menuList){
				if(menu.getId() == menuItemId){
					menuItem=menu;
					break;
				}
			}
			if (userCarts.containsKey(user)) {
				CartDTO cart = userCarts.get(user);
				ArrayList<MenuItem> menuItemList = cart.getList();
				menuItemList.add(menuItem);
				cart.setList(menuItemList);
				cart.setTotal(cart.getTotal()+menuItem.getPrice());
				System.out.println(cart.getTotal()+" "+"secnd");
				userCarts.put(user, cart);
				System.out.println(userCarts.containsKey(user)+" "+userCarts.get(user)+" " + "secnd");
			} else {
				CartDTO cart = new CartDTO(new ArrayList<MenuItem>(), 0);
				ArrayList<MenuItem> list = cart.getList();
				if (!userCarts.containsKey(user)) {
					list.add(menuItem);
					cart.setList(list);
					cart.setTotal(cart.getTotal()+menuItem.getPrice());
					System.out.println(cart.getTotal()+" "+"frst");
					userCarts.put(user, cart);
					System.out.println(userCarts.containsKey(user)+" "+userCarts.get(user)+" "+"frst");
				}
			}
		}

	@Override
	public CartDTO getAllCartItems(String user) {
		// TODO Auto-generated method stub
		if(userCarts.containsKey(user)){
			return userCarts.get(user);
		}
		return null;
			}

	@Override
	public CartDTO deleteCartItem(String user, long menuItemId) {
		try {
			CartDTO cart = userCarts.get(user);
			ArrayList<MenuItem> list = cart.getList();
			for (MenuItem menuItem : list) {
				if (menuItem.getId() == menuItemId) {
					cart.setTotal(cart.getTotal()-menuItem.getPrice());
					list.remove(menuItem);
					cart.setList(list);
					return cart;
				}
			}
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception while removing");
		}
		return null;
		// TODO Auto-generated method stub
		}
*/
}
