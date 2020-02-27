package com.ing.hackthon.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.hackthon.userStatistics.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceMockitoTest {
	
	@Autowired
	private ProductService productService;
	
	@MockBean
	private ProductGroupRepository productGroupRepository;
	
	@MockBean
	private ProductRepository productRepository;

	
	@Test 
	public void getAllProductGroupsTest() {
		when(productGroupRepository.findAll()).thenReturn(Arrays.asList(
				new ProductGroup(1, "saving"),
				new ProductGroup(2, "morkage")
				));
		
		assertNotNull(productService.getAllProductGroups());
		assertEquals("This method tests the size of the returned product groups list", 2, productService.getAllProductGroups().size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first product group", 1, productService.getAllProductGroups().get(0).getId());
		assertEquals("This method tests the name of the first product group", "saving", productService.getAllProductGroups().get(0).getName());
		
	}
	
	@Test
	public void getProductsTest() {
		
		when(productRepository.findByUserId(1)).thenReturn(getMockedProducts());
		
		assertNotNull(productService.getProducts(1));
		assertEquals("This method tests the size of the returned product groups list", 3, productService.getProducts(1).size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first product group", 1, productService.getProducts(1).get(0).getId());
		assertEquals("This method tests the name of the first product group", "orange", productService.getProducts(1).get(0).getName());
		assertEquals("This method tests the userName of the first product group", "test", productService.getProducts(1).get(0).getUserName());
		assertEquals("This method tests the groupName of the first product group", "saving", productService.getProducts(1).get(0).getGroupName());

	}
	
	private List<Product> getMockedProducts(){
		User user = new User(1, "test", "test", "1234");
		List<ProductGroup> groups = Arrays.asList(
				new ProductGroup(1, "saving"),
				new ProductGroup(2, "morkage")
				);
		List<Product> products = Arrays.asList(
				new Product(1,"orange", 1, 1),
				new Product(2,"child", 1, 1),
				new Product(3,"interest", 1, 1),
				new Product(4,"morkage", 1, 2)
				);
		
		products.stream().forEach(p -> {
			p.setUser(user);
			p.setGroup(groups.get(p.getGroup().getId() - 1));
		});
		
		return products;
	}
	
}
