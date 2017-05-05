package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.CategoryDAO;
import com.sbk.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;


	/**
	 * Getting the single Category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}

	/**
	 * Get List of All Category
	 * */
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	/**
	 * Add Category
	 */
	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {

		try {
			// update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}
	
	/* delete Category
	 * */
	@Override
	public boolean delete(Category category) {

		category.setActive(false);
		try {
			// update the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;

		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

}
