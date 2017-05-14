package com.sbk.shoppingbackend.dao;

import java.util.List;

import com.sbk.shoppingbackend.dto.User;

public interface UserDAO {

	// get single user by id
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
}
