package com.sbk.shoppingbackend.dao;

import java.util.List;

import com.sbk.shoppingbackend.dto.Address;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.User;

public interface UserDAO {

/*	// get single user by id
	User get(int userId);
	
	// get List of all User
	List<User> list();
	
	// add User
	boolean add(User user);
	
	// update User
	boolean update(User user);
	
	//delete User
	boolean delete (User user);
	
	//business method
	
	// list of all active User
	List<User> listActiveUser();
	
	// list of active user by role
	List<User> listActiveUserByRole(String role);
	
	// get user by email
	User getByEmail(String email);
	
	// get user by contact number
	User getByContactNumber(String contact_number);*/
	
	// ADD USER
	boolean addUser(User user);
	
	// add address
	boolean addAddress(Address address);
	
	
	// Alternative
	
	// get billing address
	//Address getBillingAddress(int userId);
		
	//get list of shipping address
	//List<Address> listShippingAddresses(int userId);
	
	// get billing address
	Address getBillingAddress(User user);
	
	//get list of shipping address
	List<Address> listShippingAddresses(User user);		
	
	//update cart
	boolean updateCart(Cart cart);
	
	User getByEmail(String email);
	
	// get single user by id
		User get(int userId);
		
	/*//  get cart by id
	Cart getById(int cartId);*/	
		
		
		
}
