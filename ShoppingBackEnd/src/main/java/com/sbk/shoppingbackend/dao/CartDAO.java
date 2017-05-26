package com.sbk.shoppingbackend.dao;

import com.sbk.shoppingbackend.dto.Cart;

public interface CartDAO {

	//get cart by user id
	Cart getCart(int userId);
	
	//update cart
	boolean updateCart(Cart cart);
	
	// update grand total
	void grandTotal(Cart cart);
}
