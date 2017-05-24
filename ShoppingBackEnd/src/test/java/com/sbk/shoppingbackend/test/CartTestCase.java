/*package com.sbk.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.CartDAO;
import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.CartItems;
import com.sbk.shoppingbackend.dto.User;

public class CartTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private static CartItemDAO cartItemDAO;
	private static CartDAO cartDAO;
	
	private Cart cart = null;
	private  User user =null;
	private CartItems cartItems =null;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		cartDAO = (CartDAO) context.getBean("cartDAO");
	}
	
	
	@Test
	public void testUpdateCart(){
		
		// fetch the user by its email
		user = new User();
		user =userDAO.getByEmail("maheshwaghmare@gmail.com");
		
		// get the cart of the user
		
		cart = user.getCart();
		
		// fetch the cart items of cart
		cart.setNoOfCartItems(10);
		cart.setGrandTotal(25000);
	
		
		assertEquals("Failed to update cart!",true,cartDAO.updateCart(cart));
	}
	
	@Test
	public void testGrandTotal()
	{
		user = new User();
		user =userDAO.getByEmail("maheshwaghmare@gmail.com");
		cart = user.getCart();
		cart.getCartItems();
		
		assertEquals("Failed to get the Grand Total!",350000,cartDAO.grandTotal(cart));
	}
}
*/