/*package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.OrderDAO;
import com.sbk.shoppingbackend.dto.Order;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Order order) {
		
		try {
			sessionFactory.getCurrentSession().save(order);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Order> list(int userId) {
		
		String selectQuery = "FROM Order WHERE userId= :userId";
		Query query = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("userId", userId);
		return query.list();
	}
	
	
}
*/