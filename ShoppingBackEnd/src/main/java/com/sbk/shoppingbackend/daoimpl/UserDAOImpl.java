package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Getting single User by id
	 */
	@Override
	public User get(int userId) {
		
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(userId));
	}
	
	/**
	 * Get the List of All User
	 */

	@Override
	public List<User> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM User",User.class).getResultList();
	}

	/**
	 * Insert User
	 */
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

	/**
	 * Update User
	 */
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

	/**
	 * Delete Product
	 */
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

	/**
	 * List of Active User
	 */
	@Override
	public List<User> listActiveUser() {
		
		String selectActiveUser = "FROM User WHERE enabled = :enabled";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveUser,User.class)
				.setParameter("enabled", true).getResultList();
	}

	/**
	 * List of active User by role
	 */
	@Override
	public List<User> listActiveUserByRole(String role) {
		
		String selectActiveUserRole = "FROM User WHERE enabled = :enabled AND role = :role";
		
		return sessionFactory.getCurrentSession().createQuery(selectActiveUserRole, User.class)
				.setParameter("enabled", true).setParameter("role", role).getResultList();
	}

}
