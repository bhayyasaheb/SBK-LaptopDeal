package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private static User user;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testCRUDUser()
	{
		// create operation
		user = new User();
		
		user.setFirst_name("Mangesh");
		user.setLast_name("Linge");
		user.setRole("User");
		user.setEnabled(true);
		user.setPassword("Mangesh@123");
		user.setEmail("mangeshlinge@gmail.com");
		user.setContact_number("8600193748");
		
		assertEquals("Something went wrong while inserting a new User!",true,userDAO.add(user));
		
		// reading and updating the user
		
		user= userDAO.get(4);
		user.setContact_number("8600193748");
		user.setEmail("mangeshlinge@gmail.com");
		user.setRole("USER");
		
		assertEquals("Something went wrong while updating the existing record!", true,userDAO.update(user));
		
		// delete the user
		
		assertEquals("Something went wrong while deleting the existing record!",true,userDAO.delete(user));
		
		//list of the user
		assertEquals("Something went wrong while fetching the existing record!", 4,userDAO.list().size());
	}
	
	@Test
	public void testActiveUser()
	{
		assertEquals("Something went wrong while fetching the list of Active User!",3,userDAO.listActiveUser().size());
	}
	
	@Test
	public void testActiveUserByRole()
	{
		assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("ADMIN").size());
		
		assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("SUPPLIER").size());
		
		assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("USER").size());
	}
}















