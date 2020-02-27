package com.ing.hackthon.productDetails;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductDetailsService {

	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	public List<ProductDetailsDTO> getProductDetails(int id) {		
		List<ProductDetails> productDetailsList = productDetailsRepository.findByProductId(id);
		
		return productDetailsList.stream()
				.map(this::convertToDTO)
        		.collect(Collectors.toList());
	}
	
	private ProductDetailsDTO convertToDTO(ProductDetails productDetails) {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(productDetails, ProductDetailsDTO.class);
    }
}
