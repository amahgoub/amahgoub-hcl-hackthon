package com.ing.hackthon.productDetails;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackthon.exceptions.InvalidProductException;

/**
 * Rest controller to handle productDetails requests
 */
@RestController
public class ProductDetailsController {
	private static Logger logger = LoggerFactory.getLogger(ProductDetailsController.class);

	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	/**
	 * This method for returning product details for specific product id
	 * @param id the product id 
	 * @return the product details DTOs
	 * @throws InvalidProductException in case of access product details service exceptions
	 */
	@GetMapping("/productDetails/{id}")
	public List<ProductDetailsDTO> getProductDetails(@PathVariable int id) throws InvalidProductException {
		logger.debug("getProductDetails method starts processing with product id: " + id);
		
		return productDetailsService.getProductDetails(id);
	}
}
