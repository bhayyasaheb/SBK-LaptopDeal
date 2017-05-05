package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.CategoryDAO;
import com.sbk.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() { category = new Category();
	 * 
	 * category.setName("Mobile");
	 * category.setDescription("This is description for Mobile!");
	 * category.setImageURL("CAT_107.png");
	 * 
	 * assertEquals("Sucessfully added a category inside the table!", true,
	 * categoryDAO.add(category));
	 * 
	 * }
	 */
	/*
	 * @Test public void testGetCategory(){
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Sucessfully fetched  a single category from  the table!"
	 * ,"Television",category.getName()); }
	 */

	/*
	 * @Test public void testUpdateCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * category.setName("Tv");
	 * 
	 * assertEquals("Sucessfully Updated  a single category in  the table!",
	 * true, categoryDAO.update(category)); }
	 */

	/*
	 * @Test public void testDeleteCategory() {
	 * 
	 * category = categoryDAO.get(1);
	 * 
	 * assertEquals("Sucessfully deleted  a single category in  the table!",
	 * true, categoryDAO.delete(category)); }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Sucessfully fetched the list of categories from  the table!"
	 * , 3, categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {

		// add Operation
		
		category = new Category();

		category.setName("Laptop");
		category.setDescription("This is description for Laptop!");
		category.setImageURL("CAT_1.png");

		assertEquals("Sucessfully added a category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is description for Television!");
		category.setImageURL("CAT_2.png");

		assertEquals("Sucessfully added a category inside the table!", true, categoryDAO.add(category));

		// fetching and updating category
		
		category = categoryDAO.get(2);

		category.setName("Tv");

		assertEquals("Sucessfully Updated  a single category in  the table!", true, categoryDAO.update(category));

		// delete the category
		
		assertEquals("Sucessfully deleted  a single category in  the table!", true, categoryDAO.delete(category));

		// fetching the list
		
		assertEquals("Sucessfully fetched the list of categories from  the table!" , 1, categoryDAO.list().size());
	}
}
