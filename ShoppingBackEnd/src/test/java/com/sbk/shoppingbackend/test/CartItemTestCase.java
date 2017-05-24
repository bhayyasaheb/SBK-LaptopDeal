package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dao.ProductDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.CartItems;
import com.sbk.shoppingbackend.dto.Product;
import com.sbk.shoppingbackend.dto.User;

public class CartItemTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CartItemDAO cartItemDAO;
	
	private static UserDAO userDAO;
	
	private static ProductDAO productDAO;
	
	
	private CartItems cartItems;
	
	private User user;
	
	private Cart cart;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	@Test
	public void  testCartItems(){
		
		// add cartItems
		cartItems = new CartItems();
		
		// get the user
		user = userDAO.getByEmail("maheshwaghmare@gmail.com");
		
		// fetch the cart of user
		cart=user.getCart();
		
		
		// fetch the product using id 
		 product=productDAO.get(1);
		 
		// set the product inside the cart items
		 cartItems.setProduct(product);
		
		 // fetch the price of product
		 double price= product.getUnitPrice();
		 
		cartItems.setCart(cart);
		cartItems.setQuantity(5);
		cartItems.setPrice(price);
		cartItems.setTotalAmount(cartItems.getPrice() * cartItems.getQuantity());
		
		
		
		assertEquals("Failed to add the Cart Items!",true,cartItemDAO.addCartItems(cartItems));
		
		cartItems = cartItemDAO.getCartItemsById(42);
		
		// get the user
		user = userDAO.getByEmail("maheshwaghmare@gmail.com");
				
		// fetch the cart of user
		cart=user.getCart();
					
		// fetch the product using id 
		 product=productDAO.get(1);
		 
		 //fetch the  price of the product
		 price = product.getUnitPrice();
		 
		 // set the product in cart Items
		 cartItems.setProduct(product);
		 cartItems.setCart(cart);
		 cartItems.setQuantity(cartItems.getQuantity() + 1);
		 cartItems.setPrice(price);
		 cartItems.setTotalAmount(cartItems.getPrice() * cartItems.getQuantity());
		
		 assertEquals("Failed to update the cart items!",true, cartItemDAO.updateCartItems(cartItems));
		 
		 assertEquals("Failed to delete the Cart items!",true, cartItemDAO.deleteCartItems(cartItems));
		 
		 assertEquals("Failed to fetch the list of cart Items",1,cartItemDAO.list(2).size());
		}
	
	/*@Test
	public void cartItmesGetByIdTestCase(){
		
		assertEquals("Failed to fetch the cart items by product Id!",34,cartItemDAO.getById(1,2).getId());
	}
	
	@Test
	public void getExistingCartItemTestCase(){
		
		assertEquals("Failed to Fetch the Cart Items!",true ,cartItemDAO.existingCartItem(1, 2));
	}*/
	
	/*@Test
	public void deleteAllCartItems(){
		
		assertEquals("Failed to delete all cartItems by cart id!",true, cartItemDAO.deleteAllCartItems(2));
	}*/
	
}
