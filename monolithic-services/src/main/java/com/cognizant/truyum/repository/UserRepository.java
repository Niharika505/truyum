package com.cognizant.truyum.repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("FROM User u WHERE u.username=?1")
	public User findByUsername(String name);
	User findById(int id);
	@Query("select u from User u WHERE u.username=?1")
	User getMenuItems(String username);
	/*@Query("select SUM(me_price) from cart ")
	double getCartTotal();*/
	
	
}
