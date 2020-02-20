package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartService cartService;
	
	@PostMapping("/{user}/{menuItemId}")
	public void addCart(@PathVariable String user,@PathVariable long menuItemId) throws ParseException{
		cartService.addCartItem(user, menuItemId);
	}
	
	@GetMapping("/{user}")
	public CartDTO getAllCartItems(@PathVariable("user") String userId){
		CartDTO cartDTO=new CartDTO();	
		cartDTO.setList(cartService.getAllCartItems(userId));
		cartDTO.setTotal(cartService.getCartTotal(userId));
		//return cartService.getAllCartItems(user);
		return cartDTO;
	}
	
	@DeleteMapping("/{user}/{menuItemId}")
	public CartDTO deleteCartItem(@PathVariable String user,@PathVariable long menuItemId){
		CartDTO cartDTO=new CartDTO();	
		cartDTO.setList(cartService.deleteCartItems(user, menuItemId));
		return cartDTO;
	}
}
