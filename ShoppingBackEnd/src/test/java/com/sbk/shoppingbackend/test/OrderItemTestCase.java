/*package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.AddressDAO;
import com.sbk.shoppingbackend.dao.OrderDAO;
import com.sbk.shoppingbackend.dao.OrderItemDAO;
import com.sbk.shoppingbackend.dao.ProductDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Address;
import com.sbk.shoppingbackend.dto.Order;
import com.sbk.shoppingbackend.dto.OrderItem;
import com.sbk.shoppingbackend.dto.Product;
import com.sbk.shoppingbackend.dto.User;

public class OrderItemTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static OrderItemDAO orderItemDAO;
	
	private static ProductDAO productDAO;
	
	private static UserDAO userDAO;
	
	private static OrderDAO orderDAO;
	
	private static AddressDAO addressDAO;
	
	private OrderItem orderItem;
	
	private Product product;
	
	private User user;
	
	private Order order;
	
	private Address address;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		orderItemDAO = (OrderItemDAO) context.getBean("orderItemDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		orderDAO  = (OrderDAO) context.getBean("orderDAO");
		addressDAO = (AddressDAO) context.getBean("addressDAO");
	}
	
	@Test
	public void testOrderItem()
	{
		// add orderItem
		
		orderItem =  new OrderItem();
		
		// set product
		productDAO.get(1);
		orderItem.setProduct(product);
		
		// set quantity
		orderItem.setQuantity(5);
		
		// set Total amount
		orderItem.setTotalAmount(product.getUnitPrice() * orderItem.getQuantity());
		
		//get the user
		user =userDAO.getByEmail("maheshwaghmare@gmail.com");
		
		// fetch the order
		order = (Order) user.getOrder();
	
		// set order
		orderItem.setOrder(order);
		
		assertEquals("Failed to add the orderItem!",true,orderItemDAO.addOrderItem(orderItem));
		
	}
	
	@Test
	public void addOrderTestCase(){
		
		//get the user	
		user = userDAO.getByEmail("maheshwaghmare@gmail.com");
		
		//add address to the user
		address = new Address();
		
		address.setAddressLineOne("101");
		address.setAddressLineTwo("202");
		address.setCity("Satara");
		address.setPostalCode("415506");
		address.setState("Maharashtra");
		address.setBilling(true);
		
		address.setUser(user);
		
		assertEquals("Failed to add the Billing Address!",true,addressDAO.addAddress(address));
		
		// add the shipping address;
		
		address.setAddressLineOne("102");
		address.setAddressLineTwo("201");
		address.setCity("Mhaswad");
		address.setPostalCode("415001");
		address.setState("Maharashtra");
		address.setShipping(true);
		
		address.setUser(user);
		assertEquals("Failed to add the Shipping Address!",true,addressDAO.addAddress(address));
		
		
		order =new Order();
		
		order.setUser(user);
		order.setAddress(user.getAddress());
		order.setGrandTotal(50000);
		
		assertEquals("failed to add the order!",true, orderDAO.add(order));
		
	}
}
*/