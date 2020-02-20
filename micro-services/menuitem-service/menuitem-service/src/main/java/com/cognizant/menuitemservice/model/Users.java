package com.cognizant.menuitemservice.model;

import java.util.Collection;

import javax.validation.Valid;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

public class Users {

	@Valid
	private String username;
	@Valid
	private String password;
	@Valid
	private String firstName;
	@Valid
	private String lastName;
	@Valid
	private String confirmPassword;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setlastName(String secondName) {
		this.lastName = secondName;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String conformPassword) {
		this.confirmPassword = conformPassword;
	}
	
	
}
