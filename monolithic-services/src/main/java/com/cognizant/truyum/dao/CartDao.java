package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.*;

public interface CartDao {

	public void addCartItem(String user, long menuItemId) throws ParseException;

	public CartDTO getAllCartItems(String user);

	public CartDTO deleteCartItem(String user, long menuItemId);

}
