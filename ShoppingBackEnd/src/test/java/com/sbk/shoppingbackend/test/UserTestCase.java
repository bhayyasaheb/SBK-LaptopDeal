package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.CartItemDAO;
import com.sbk.shoppingbackend.dao.UserDAO;
import com.sbk.shoppingbackend.dto.Address;
import com.sbk.shoppingbackend.dto.Cart;
import com.sbk.shoppingbackend.dto.CartItems;
import com.sbk.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	
	
	private static UserDAO userDAO;
	
	/*private static User user;*/
	
	private static CartItemDAO cartItemDAO;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		cartItemDAO = (CartItemDAO) context.getBean("cartItemDAO");
	}
	
	/*@Test
	public void testCRUDUser()
	{
		// create operation
		user = new User();
		
		user.setFirst_name("Bhayyasaheb");
		user.setLast_name("Koke");
		user.setDob("30/04/1993");
		user.setRole("Admin");
		user.setEnabled(true);
		user.setPassword("SBK@123");
		user.setEmail("bhayyasahebkoke@gmail.com");
		user.setContact_number("9730586363");
		
		assertEquals("Something went wrong while inserting a new User!",true,userDAO.addUser(user));
		
		// reading and updating the user
		
		user= userDAO.get(1);
		//user.setContact_number("8600193748");
		//user.setEmail("mangeshlinge@gmail.com");
		user.setRole("ADMIN");
		user.setEnabled(true);
		
		//assertEquals("Something went wrong while updating the existing record!", true,userDAO.update(user));
		
		// delete the user
		
		//assertEquals("Something went wrong while deleting the existing record!",true,userDAO.delete(user));
		
		//list of the user
		//assertEquals("Something went wrong while fetching the existing record!", 1,userDAO.list().size());
	}*/
	
	/*@Test
	public void testActiveUser()
	{
		assertEquals("Something went wrong while fetching the list of Active User!",1,userDAO.listActiveUser().size());
	}
	
	@Test
	public void testActiveUserByRole()
	{
		assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("ADMIN").size());
		
		//assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("SUPPLIER").size());
		
		//assertEquals("Something went wrong while fetching the list of Active user by Role!",1,userDAO.listActiveUserByRole("USER").size());
	}
	
	@Test
	public void testUserByEmail()
	{
		user=userDAO.getByEmail("bhayyasahebkoke@gmail.com");
		System.out.println(user);
		assertEquals("Something went wrong while fetching the Email of User!","bhayyasahebkoke@gmail.com",user.getEmail());
	}
	@Test 
	public void testUserByContactNumber()
	{
		user=userDAO.getByContactNumber("9730586363");
		assertEquals("Something went wrong while fetching the Contact Number of User!","9730586363",user.getContact_number());
	}*/
	
	
	private User user = null;
	private Cart cart = null;
	private Address address = null;
	private CartItems cartItems = null;
	
/*	@Test
	public void testAdd(){
		
		user = new User();
		user.setFirst_name("Bhayyasaheb");
		user.setLast_name("Koke");
		user.setDob("30/04/1993");
		user.setPassword("SBK@123");
		user.setEmail("bhayyasahebkoke@gmail.com");
		user.setContact_number("9730586363");
		user.setRole("USER");
		
		// add the user
		assertEquals("Failed to add User!",true,userDAO.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("Shree Ganesh App,Room No-001 ,Plot No-299");
		address.setAddressLineTwo("Near Dr. DY Patil Stedium, Shiravanegaon");
		address.setCity("Nerul");
		address.setState("Maharashtra");
		address.setPostalCode("400706");
		address.setBilling(true);
		
		// link the user with address using user id
		address.setUserId(user.getId());
		
		// add the address
		assertEquals("Failed to add Address!",true,userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")){
			
			// create cart for this address
			cart = new Cart();
			cart.setUser(user);
			
			// add the Cart
			assertEquals("Failed to add Cart!",true,userDAO.addCart(cart));
			
			// add a shipping address for this user
			
			address = new Address();
			address.setAddressLineOne("Shree Ganesh App,Room No-001 ,Plot No-299");
			address.setAddressLineTwo("Near Dr. DY Patil Stedium, Shiravanegaon");
			address.setCity("Nerul");
			address.setState("Maharashtra");
			address.setPostalCode("400706");
			// set shipping address to true
			address.setShipping(true);
			
			// link with user
			address.setUserId(user.getId());
			
			// add the shipping address
			assertEquals("Failed to add Shipping Address!",true,userDAO.addAddress(address));
			
		}
	}
*/
	
	/*@Test
	public void testAdd(){
		
		user = new User();
		user.setFirst_name("Mangesh");
		user.setLast_name("Linge");
		user.setDob("05/12/1992");
		user.setPassword("Mangesh@123");
		user.setEmail("mangeshlinge@gmail.com");
		user.setContact_number("8600193748");
		user.setRole("USER");
		
		
		if(user.getRole().equals("USER")){
			
			// create cart for this address
			cart = new Cart();
			cart.setUser(user);
			
			// attach cart with the cart
			user.setCart(cart);
		}
		
		
		
		// add the user
		assertEquals("Failed to add User!",true,userDAO.addUser(user));
				
	}*/
	
	/*@Test
	public void testUpdateCart(){
		
		// fetch the user by its email
		
		user =userDAO.getByEmail("maheshwaghmare@gmail.com");
		
		// get the cart of the user
		
		cart = user.getCart();
		
		// fetch the cart items of cart
		//cart.getNoOfCartItems();
		
		cartItemDAO.getCartItemsById(cart.getId());
		
		//cart.getCartItems();
		//cart.getNoOfCartItems();
		//cart.setNoOfCartItems(5);
		cart.getGrandTotal();
	
		
		assertEquals("Failed to update cart!",true,userDAO.updateCart(cart));
	}*/
	
	/*@Test
	public void testAddAddress(){
		
		// we need to add user
		user = new User();
		user.setFirst_name("Mahesh");
		user.setLast_name("Waghmare");
		user.setDob("11/01/1993");
		user.setPassword("Mahesh@123");
		user.setEmail("maheshwaghmare@gmail.com");
		user.setContact_number("9665224303");
		user.setRole("USER");
		
		if(user.getRole().equals("USER")){
			
			// create cart for this address
			cart = new Cart();
			cart.setUser(user);
			
			// attach cart with the user
			user.setCart(cart);
		}
		
		// add the user
		assertEquals("Failed to add User!",true,userDAO.addUser(user));
		
		// we are going to add billing address
		
		address = new Address();
		address.setAddressLineOne("Shree Ganesh App,Room No-001 ,Plot No-299");
		address.setAddressLineTwo("Near Dr. DY Patil Stedium, Shiravanegaon");
		address.setCity("Nerul");
		address.setState("Maharashtra");
		address.setPostalCode("400706");
		address.setBilling(true);
		
		// attached the user to the address
		address.setUser(user);
		
		// add the  billing address
		assertEquals("Failed to add Address!",true,userDAO.addAddress(address));
		
		// we are going to add the shipping address
		address = new Address();
		address.setAddressLineOne("Shree Ganesh App,Room No-001 ,Plot No-299");
		address.setAddressLineTwo("Near Dr. DY Patil Stedium, Shiravanegaon");
		address.setCity("Nerul");
		address.setState("Maharashtra");
		address.setPostalCode("400706");
		// set shipping address to true
		address.setShipping(true);
		
		// attached to user to the address
		address.setUser(user);
		
		// add the shipping address
		assertEquals("Failed to add Shipping Address!",true,userDAO.addAddress(address));
	}*/
	
	/*@Test
	public void testAddress(){
		
		user = userDAO.getByEmail("bhayyasahebkoke@gmail.com");
		
		// we are going to add the shipping address
		
		address = new Address();
		address.setAddressLineOne("Shree Ganesh App,Room No-001 ,Plot No-299,Ground floor");
		address.setAddressLineTwo("Near Dr. DY Patil Stedium, Shiravanegaon");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setPostalCode("400001");
		// set shipping address to true
		address.setShipping(true);
		
		// attached to user to the address
		address.setUser(user);
		
		// add the shipping address
		assertEquals("Failed to add Shipping Address!",true,userDAO.addAddress(address));
	}*/

/*	@Test
	public void testGetAddresses(){
		
		user  = userDAO.getByEmail("bhayyasahebkoke@gmail.com");
		
		assertEquals("Failed to fetch list of shipping address and size does not match!",2,
							userDAO.listShippingAddresses(user).size());
		
		assertEquals("Failed to fetch  billing  address and size does not match!","Nerul",
				userDAO.getBillingAddress(user).getCity());
	}
	*/

	/*@Test
	public void testUserByEmail()
	{
		user=userDAO.getByEmail("bhayyasahebkoke@gmail.com");
		System.out.println(user);
		assertEquals("Something went wrong while fetching the Email of User!","bhayyasahebkoke@gmail.com",user.getEmail());
	}*/

}















