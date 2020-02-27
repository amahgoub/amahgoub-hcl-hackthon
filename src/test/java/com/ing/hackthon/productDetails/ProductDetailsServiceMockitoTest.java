package com.ing.hackthon.productDetails;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.hackthon.product.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDetailsServiceMockitoTest {

	@Autowired
	private ProductDetailsService productDetailsService;
	
	@MockBean
	private ProductDetailsRepository productDetailsRepository;
	
	@Test
	public void getProductDetailsTest() {
		Product product = new Product(1,"orange", 1, 1);
		when(productDetailsRepository.findByProductId(1)).thenReturn(getMockedProductDetails(product));
		
		assertNotNull(productDetailsService.getProductDetails(1));
		assertEquals("This method tests the size of the returned product details list", 1, productDetailsService.getProductDetails(1).size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first product details", 1, productDetailsService.getProductDetails(1).get(0).getId());
		assertEquals("This method tests the account of the first product details", "NL21INGB1234567801", productDetailsService.getProductDetails(1).get(0).getAccount());
		assertEquals("This method tests the balance of the first product details", 12.12, productDetailsService.getProductDetails(1).get(0).getBalance(), 0.0);
		assertEquals("This method tests the product Name of the first product details", "orange", productDetailsService.getProductDetails(1).get(0).getProductName());
				
	}
	
	private List<ProductDetails> getMockedProductDetails(Product product) {
		List<ProductDetails> productDetails = Arrays.asList(
				new ProductDetails(1, "NL21INGB1234567801", 12.12, 1),
				new ProductDetails(2, "NL21INGB1234567802", 12.12, 2),
				new ProductDetails(3, "NL21INGB1234567803", 12.12, 3),
				new ProductDetails(4, "NL21INGB1234567804", 12.12, 4)
				);
		
		return productDetails.stream()
				.filter(p -> p.getProduct().getId() == product.getId())
				.map(p -> {
					p.setProduct(product); 
					return p;
					})
				.collect(Collectors.toList());
	}
}
