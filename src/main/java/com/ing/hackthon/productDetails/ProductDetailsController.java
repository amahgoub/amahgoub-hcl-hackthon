package com.ing.hackthon.productDetails;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController {
	
	@Autowired
	private ProductDetailsService productDetailsService;
	
	@GetMapping("/productDetails/{id}")
	public List<ProductDetailsDTO> getProductDetails(@PathVariable int id) {
		return productDetailsService.getProductDetails(id);
	}
}
