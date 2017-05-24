package com.sbk.shoppingbackend.dao;

import java.util.List;

import com.sbk.shoppingbackend.dto.CartItems;

public interface CartItemDAO {

	// list of cart items
	List<CartItems> list(int cartId);
	
	// get Cart items by cart items id
	CartItems getCartItemsById(int cartItemsId);
	
	// get Cart Items By Product Id and cart id
	CartItems getById(int productId,int cartId);
	
	// get existing cart items for grand total
	boolean existingCartItem(int productId,int cartId);
	
	// add cart items
	boolean addCartItems(CartItems cartItems);
	
	//update cart items
	boolean updateCartItems(CartItems cartItems);
	
	// delete cart items
	boolean deleteCartItems(CartItems cartItems);
	
	// delete all cartItems of user
	boolean deleteAllCartItems(int cartId);
}
