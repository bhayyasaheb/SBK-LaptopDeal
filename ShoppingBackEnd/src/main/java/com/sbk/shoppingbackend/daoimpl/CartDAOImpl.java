/*package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.CartDAO;
import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.CartItems;
import com.sbk.shoppingbackend.dto.User;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	UserDAO userDAO;
	
	@Autowired 
	User user;
	
	@Autowired
	CartItemDAO cartItemDAO;
	
	@Autowired
	Cart cart;
	
	@Override
	public Cart getCart(int userId) {
		
		user = userDAO.get(userId);
		int cartId = user.getCart().getId();
		return sessionFactory.getCurrentSession().get(Cart.class, cartId);
	}

	@Override
	public boolean updateCart(Cart cart) {
		
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void grandTotal(Cart cart) {
		
		double grandTotal = 0;
		
		List<CartItems> listOfCartItems = cartItemDAO.list(user.getCart().getId());
		cart.setNoOfCartItems(listOfCartItems.size());
		for(CartItems cartItems : listOfCartItems){
			grandTotal =grandTotal + cartItems.getTotalAmount();
		}
		cart.setGrandTotal(grandTotal);
	}
	
	
}
*/