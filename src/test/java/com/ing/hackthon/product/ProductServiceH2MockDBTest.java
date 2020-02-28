package com.ing.hackthon.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceH2MockDBTest {

	@Autowired
	private ProductService productService;
	
	@Test
	public void getAllProductGroupsTest() {
		
		assertNotNull(productService.getAllProductGroups());
		assertEquals("This method tests the size of the returned product groups list", 3, productService.getAllProductGroups().size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first product group", 1, productService.getAllProductGroups().get(0).getId());
		assertEquals("This method tests the name of the first product group", "Savings", productService.getAllProductGroups().get(0).getName());
		
	}
	
	@Test
	public void getProductsTest() {
		
		assertNotNull(productService.getProducts(1));
		assertEquals("This method tests the size of the returned product groups list", 3, productService.getProducts(1).size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first product group", 2, productService.getProducts(1).get(0).getId());
		assertEquals("This method tests the name of the first product group", "Child savings account", productService.getProducts(1).get(0).getName());
		assertEquals("This method tests the userName of the first product group", "test1", productService.getProducts(1).get(0).getUserName());
		assertEquals("This method tests the groupName of the first product group", "Savings", productService.getProducts(1).get(0).getGroupName());

	}
}
