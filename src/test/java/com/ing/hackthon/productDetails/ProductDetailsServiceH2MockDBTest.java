package com.ing.hackthon.productDetails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.hackthon.exceptions.InvalidProductException;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDetailsServiceH2MockDBTest {

	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@Test
	public void getProductDetailsTest() {
		try {
			assertNotNull(productDetailsService.getProductDetails(1));
			assertEquals("This method tests the size of the returned product details list", 1, productDetailsService.getProductDetails(1).size());
			
			// Testing the DTO conversion
			assertEquals("This method tests the id of the first product details", 1, productDetailsService.getProductDetails(1).get(0).getId());
			assertEquals("This method tests the account of the first product details", "NL21INGB1234567001", productDetailsService.getProductDetails(1).get(0).getAccount());
			assertEquals("This method tests the balance of the first product details", 1201.0, productDetailsService.getProductDetails(1).get(0).getBalance(), 0.0);
			assertEquals("This method tests the product Name of the first product details", "mock Orange savings account", productDetailsService.getProductDetails(1).get(0).getProductName());
		} catch (InvalidProductException e) {
			fail();
		}
				
	}
}
