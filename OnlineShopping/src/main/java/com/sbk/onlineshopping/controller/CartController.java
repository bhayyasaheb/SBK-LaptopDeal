package com.sbk.onlineshopping.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sbk.shoppingbackend.dao.CartDAO;
import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dao.ProductDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.CartItems;
import com.sbk.shoppingbackend.dto.Product;
import com.sbk.shoppingbackend.dto.User;

@Controller
public class CartController {
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired 
	private User user;
	
	@Autowired 
	private ProductDAO productDAO;
	
	@Autowired 
	private Product product;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
		
	@Autowired 
	private CartItemDAO cartItemDAO;
	
	@Autowired 
	private CartItems cartItems;
	
	
	
	
	/*
	 * Method to access Cart Page
	 */
	
	@RequestMapping(value="/cart")
	public ModelAndView showCart(Principal principal)
	{
		logger.debug("Starting of the method Show cart");
		
		ModelAndView mv = new ModelAndView("page");
		
		//fetch user from principal
		user =userDAO.getByEmail(principal.getName());
		
		// fetch list of cart items using cart id 
		List<CartItems> cartItems = cartItemDAO.list(user.getCart().getId());
		
		mv.addObject("cartItemsIsEmpty",cartItems.isEmpty());
		session.setAttribute("noOfCartItems", cartItems.size());
		mv.addObject("cartItem",cartItems);
		mv.addObject("cartItems",new CartItems());
		mv.addObject("cart" , cartDAO.getCart(user.getId()));
		//mv.addObject("cart",user.getCart().getGrandTotal());
		//mv.addObject("cart",new Cart());
		mv.addObject("title","Cart");
		mv.addObject("isUserClickedCart",true);
		
		logger.debug("Ending of the method show Cart");
		
		return mv;
	}
	
	@RequestMapping(value="/cart/add/{id}/product")
	public String addCartItem(@PathVariable("id") int productId, Principal principal)
	{
		String url = null;
		
		user = userDAO.getByEmail(principal.getName());
		product = productDAO.get(productId);
		
		//Set<CartItems> cartItem = new HashSet<>();
		
		cart = user.getCart();
		
		boolean flag = cartItemDAO.existingCartItem(product.getId(), cart.getId());
		
		if(product.getQuantity() != 0)
		{
			// if product does not exist in the cart then add it as a new product
			
			if(flag != true)
			{
				cartItems.setProduct(product);
				cartItems.setQuantity(1); // default quantity
				cartItems.setPrice(product.getUnitPrice());
				cartItems.setTotalAmount(cartItems.getPrice() * cartItems.getQuantity());
				cartItems.setCart(cart);
				
				//cartItem.add(cartItems);
				cartItemDAO.addCartItems(cartItems);
				product.setQuantity(product.getQuantity() - 1);
				productDAO.update(product);
				cart.setNoOfCartItems(cart.getNoOfCartItems() + cartItems.getQuantity());
				cart.setGrandTotal(cart.getGrandTotal() + cartItems.getTotalAmount() );
				userDAO.updateCart(cart);
				
				url ="redirect:/cart?op=add&status=success";
							
			}
			else
			{
				// if product already exist increment quantity by 1
				
				CartItems exitItem = cartItemDAO.getById(product.getId(), cart.getId());
				exitItem.setQuantity(exitItem.getQuantity() +1);
			
				exitItem.setTotalAmount(exitItem.getTotalAmount() + product.getUnitPrice());
				
				
				
				cartItemDAO.updateCartItems(exitItem);
				
				product.setQuantity(product.getQuantity() - 1);
				productDAO.update(product);
				
				//cart.setNoOfCartItems(cart.getNoOfCartItems() + cartItems.getQuantity());
				cart.setGrandTotal(cart.getGrandTotal() + product.getUnitPrice());
				
				userDAO.updateCart(cart);
				
				url ="redirect:/cart?op=add&status=success";
			}
			
		}
		else
		{
			url = "redirect:/cart?op=add&status=failure";
		}
		
		return url;
	}
	
	
	@RequestMapping(value="/cart/delete/{id}")
	public String deleteCartItem(@PathVariable("id") int id,Principal principal)
	{
		String url = null;
		
		user = userDAO.getByEmail(principal.getName());
		
		if(id != 0)
		{
			cart = user.getCart();
			cartItems = cartItemDAO.getCartItemsById(id);
			
			/*product = productDAO.get(cartItems.getProduct().getId());
			product.setQuantity(product.getQuantity() + cartItems.getQuantity());
			productDAO.update(product);*/
			
			cart.setNoOfCartItems(cart.getNoOfCartItems() - 1);
			cart.setGrandTotal(cart.getGrandTotal() - cartItems.getTotalAmount());
			
			cartItemDAO.deleteCartItems(cartItems);
			
			userDAO.updateCart(cart);
			
			return url = "redirect:/cart?op=delete&status=success";
		}
		else
		{
			return url ="redirect:/cart?op=delete&status=failure";
		}
		
	}
	
	/*@RequestMapping(value="/cart/deleteAll/{id}")
	public String deleteCart(@PathVariable("id") int id, Principal principal)
	{
		user = userDAO.getByEmail(principal.getName());
		
		if(id != 0)
		{
			cart = user.getCart();
			cartItemDAO.deleteAllCartItems(id);
			userDAO.updateCart(cart);
		}
		
		return "redirect:shippingAddress";
	}*/
	
	
	
}



























