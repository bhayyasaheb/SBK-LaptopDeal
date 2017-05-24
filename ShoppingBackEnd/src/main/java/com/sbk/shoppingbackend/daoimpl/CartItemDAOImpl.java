package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dto.CartItems;

@Repository("cartItemDAO")
@Transactional
public class CartItemDAOImpl implements CartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	


	/**
	 * Get list of cart Items
	 */
	@Override
	public List<CartItems> list(int cartId) {
		
		String hql = "FROM CartItems WHERE cart.id = :cartId";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("cartId", cartId);
		return query.list();
		
		//return sessionFactory.getCurrentSession().createQuery("FROM CartItems",CartItems.class).getResultList();
	}

	/**
	 * Getting single CartItems Based on cartItems id
	 */
	@Override
	public CartItems getCartItemsById(int cartItemsId) {

		return sessionFactory.getCurrentSession().get(CartItems.class, Integer.valueOf(cartItemsId));
	}

	/**
	 * Insert CartItems
	 */
	@Override
	public boolean addCartItems(CartItems cartItems) {
		
		try {
			sessionFactory.getCurrentSession().persist(cartItems);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Update CartItems
	 */
	@Override
	public boolean updateCartItems(CartItems cartItems) {
		
		try {
			sessionFactory.getCurrentSession().update(cartItems);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 *  Delete CartItems
	 */
	@Override
	public boolean deleteCartItems(CartItems cartItems) {
		
		try {
			 sessionFactory.getCurrentSession().delete(cartItems);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Getting  cartItems Based on Product id
	 */
	@Override
	public CartItems getById(int productId,int cartId) {
		
		String selectQuery = "FROM CartItems WHERE product_Id = :productId AND Cart_Id = :cartId";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("cartId",cartId);
		query.setParameter("productId", productId);
		List<CartItems> cartItems = query.getResultList();
		if(cartItems != null && !cartItems.isEmpty()){
			return cartItems.get(0);
		}
		return null;
		
		/*try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, CartItems.class)
					.setParameter("productId", productId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}*/
		
		//return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
	}

	/**
	 * 
	 * getting existing CartItems by productid and cart id
	 */
	@Override
	public boolean existingCartItem(int productId,int cartId) {
		
		String selectQuery ="FROM CartItems WHERE product_Id= :productId AND cart_Id = :cartId";
	
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("productId", productId);
		query.setParameter("cartId", cartId);
		if(query.list().isEmpty()){
			return false;
		}else {
			return true;
		}
	}

	@Override
	public boolean deleteAllCartItems(int cartId) {

		try {
			sessionFactory.getCurrentSession().createQuery("delete from CartItems where Cart_Id = :cartId").setParameter("cartId", cartId).executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	

}
