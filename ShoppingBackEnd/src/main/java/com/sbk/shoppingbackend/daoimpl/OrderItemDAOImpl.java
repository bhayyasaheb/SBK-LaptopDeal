/*package com.sbk.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sbk.shoppingbackend.dao.OrderItemDAO;
import com.sbk.shoppingbackend.dto.OrderItem;

@Repository("orderItemDAO")
@Transactional
public class OrderItemDAOImpl implements OrderItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<OrderItem> list(int orderId) {
		
		String selectQuery =  "FROM OrderItem WHERE order.id = :orderId";
		Query query  = sessionFactory.getCurrentSession().createQuery(selectQuery);
		query.setParameter("orderId", orderId);
		return query.list();
	}

	@Override
	public OrderItem getById(int orderItemId) {
		return sessionFactory.getCurrentSession().get(OrderItem.class,Integer.valueOf(orderItemId));
	}

	@Override
	public boolean addOrderItem(OrderItem orderItem) {
		try {
			sessionFactory.getCurrentSession().save(orderItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		
		
	}

	@Override
	public boolean updateOrderItem(OrderItem orderItem) {
		
		try {
			sessionFactory.getCurrentSession().update(orderItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrderItem(OrderItem orderItem) {
		try {
			sessionFactory.getCurrentSession().delete(orderItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
*/