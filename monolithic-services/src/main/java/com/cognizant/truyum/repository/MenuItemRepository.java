package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
@Query("FROM MenuItem m where m.active='1' and m.dateOfLaunch<CURDATE()")
 List<MenuItem> getMenuItemListCustomer();
MenuItem findById(long id);
}
