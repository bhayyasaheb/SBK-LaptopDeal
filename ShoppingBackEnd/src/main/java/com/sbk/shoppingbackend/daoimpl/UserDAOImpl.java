package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Address;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Getting single User by id
	 */
	/*@Override
	public User get(int userId) {

		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(userId));

	}

	*//**
	 * Get the List of All User
	 *//*

	@Override
	public List<User> list() {

		return sessionFactory.getCurrentSession().createQuery("FROM User", User.class).getResultList();
	}

	*//**
	 * Insert User
	 *//*
	@Override
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	*//**
	 * Update User
	 *//*
	@Override
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	*//**
	 * Delete User
	 *//*
	@Override
	public boolean delete(User user) {
		try {
			user.setEnabled(false);
			// call the update method
			return this.update(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	*//**
	 * List of Active User
	 *//*
	@Override
	public List<User> listActiveUser() {

		String selectActiveUser = "FROM User WHERE enabled = :enabled";

		return sessionFactory.getCurrentSession().createQuery(selectActiveUser, User.class)
				.setParameter("enabled", true).getResultList();
	}

	*//**
	 * List of active User by role
	 *//*
	@Override
	public List<User> listActiveUserByRole(String role) {

		String selectActiveUserRole = "FROM User WHERE enabled = :enabled AND role = :role";

		return sessionFactory.getCurrentSession().createQuery(selectActiveUserRole, User.class)
				.setParameter("enabled", true).setParameter("role", role).getResultList();
	}

	@Override
	public User getByEmail(String email) {

		try {
			return sessionFactory.getCurrentSession().createQuery("From User where email = :email",User.class)
					.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		// return (User)
		
		 * Query query=sessionFactory.getCurrentSession().
		 * createQuery("FROM User where email=?"); query.setString(0, email);
		 * query.uniqueResult(); return (User) query;
		 

	}

	@Override
	public User getByContactNumber(String contact_number) {

		try {

			return (User) sessionFactory.getCurrentSession().createQuery("FROM User Where contact_number=?")
					.setParameter(0, contact_number).getSingleResult();

		} catch (Exception e) {
			return null;
		}
	}*/

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			}
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
	public User get(int userId) {

		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(userId));

	}

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public User getByEmail(String email) {

		try {
			return sessionFactory.getCurrentSession().createQuery("From User where email = :email",User.class)
					.setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getBillingAddress(User user) {
		String selectQuery = "FROM Address Where user = :user AND billing = :billing";
		
		try {
			return sessionFactory.getCurrentSession()
					 .createQuery(selectQuery,Address.class)
					 	.setParameter("user", user)
						.setParameter("billing",true)
						.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Address> listShippingAddresses(User user) {
		
		
		String selectQuery = "FROM Address Where user = :user AND shipping = :shipping";
		
		try {
			return sessionFactory.getCurrentSession()
					 .createQuery(selectQuery,Address.class)
					 	.setParameter("user", user)
						.setParameter("shipping",true)
						.getResultList();
						
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

	
}
