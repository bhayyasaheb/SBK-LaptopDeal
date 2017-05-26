/*package com.sbk.shoppingbackend.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.OrderDAO;
import com.sbk.shoppingbackend.dto.Order;

public class OrderTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static Order order;
	
	private static OrderDAO orderDAO;
	
	@BeforeClass
	public static void init()
	{
		context =  new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		orderDAO = (OrderDAO) context.getBean("orderDAO");
		order = (Order) context.getBean("order");
	}
	
	@Test
	public void addOrderTestCase()
	{
		order.setUserId(5);
		order.setStatus("N");
		order.setDate_ordered(new Date());
		
		assertEquals("failed to add order!",true,orderDAO.add(order));
	}
}
*/