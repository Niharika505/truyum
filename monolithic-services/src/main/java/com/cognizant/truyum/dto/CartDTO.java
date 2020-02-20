package com.cognizant.truyum.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.cognizant.truyum.model.MenuItem;

public class CartDTO {
	
	Set<MenuItem> list = new HashSet<>();
	private double total;

	public CartDTO(Set<MenuItem> menuItem, double total) {
		this.list = menuItem;
		this.total = total;
	}

	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public Set<MenuItem> getList() {
		return list;
	}

	public void setList(Set<MenuItem> set) {
		this.list = set;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
