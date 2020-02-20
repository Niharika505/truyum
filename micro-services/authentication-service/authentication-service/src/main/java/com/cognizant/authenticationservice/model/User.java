package com.cognizant.authenticationservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	  
    @Id
    @Column(name="us_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
   
    @Column(name="us_username")
    private String username;
	
    
    @Column(name="us_password")
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
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


	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
    private Set<Role> roleList ;
	@ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(name = "cart",
		        joinColumns = @JoinColumn(name = "ct_us_id"), 
		        inverseJoinColumns = @JoinColumn(name = "ct_pr_id"))
		    private Set<MenuItem> cartList ;
			
	
	
	public Set<MenuItem> getCartList() {
		return cartList;
	}
	public void setCartList(Set<MenuItem> cartList) {
		this.cartList = cartList;
	}
	public Set<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(Set<Role> roleList) {
		this.roleList = roleList;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
//		, roleList=" + roleList
//				+ ", cartList=" + cartList + "]";
	}
	
    
}
