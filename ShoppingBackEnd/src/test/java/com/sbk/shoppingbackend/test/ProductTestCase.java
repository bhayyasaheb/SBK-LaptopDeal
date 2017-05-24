package com.sbk.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sbk.shoppingbackend.dao.ProductDAO;
import com.sbk.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.sbk.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
	
	@Test
	public void testCRUDProduct(){
		
		// create Operation
		product = new Product();
		
		product.setName("SAMSUNG Galaxy S8 Plus(Maple Gold, 64 GB 4 GB RAM)");
		product.setBrand("Samsung");
		product.setDescription("Boasting a top-notch security system featuring an Iris scanner, face recognition, fingerprint reader and more, the Galaxy S8 Plus keeps your private data safe from prying eyes. Its powerful 8 MP front camera and 12 MP rear camera");
		product.setUnitPrice(64900);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		
		assertEquals("Something went wrong while inserting a new product!",true,productDAO.add(product));
		
		
		// reading and updating the product
		
		/*product =productDAO.get(10);
		product.setQuantity(5);
		product.setUnitPrice(64900);*/
		
		//assertEquals("Something went wrong while updating the existing record!",true,productDAO.update(product));
		
		// delete product
		
		//assertEquals("Something went wrong while deleting the existing record!",true,productDAO.delete(product));
		
		//list of the product
		//assertEquals("Something went wrong while fetching the list of products!",11,productDAO.list().size());
		
	}

	
/*	@Test
	public void testActiveProducts(){
		
		assertEquals("Something went wrong while fetching the list of Active products!",11,productDAO.listActiveProducts().size());
	}
	
	@Test
	public void testActiveProductsByCategory(){
		
		assertEquals("Something went wrong while fetching the list of Active products by category!",5,productDAO.listActiveProductsByCategory(3).size());
		
		assertEquals("Something went wrong while fetching the list of Active products by category!",3,productDAO.listActiveProductsByCategory(2).size());
		
		assertEquals("Something went wrong while fetching the list of Active products by category!",3,productDAO.listActiveProductsByCategory(1).size());
	
	}
	
	@Test
	public void testGetLatestActiveProducts(){
		
		assertEquals("Something went wrong while fetching the list of Active products!",3,productDAO.getLatestActiveProducts(3).size());
	}*/
}

