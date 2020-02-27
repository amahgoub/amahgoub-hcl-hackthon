package com.ing.hackthon.product;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.hackthon.userStatistics.User;

@Service
public class ProductService {

	private User loggedIndUser = new User(1,"ahmed", "asaleh", "1234");
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductGroupRepository productGroupRepository;
	
	public List<ProductGroupDTO> getAllProductGroups() {
		List<ProductGroup> repoProductGroups = productGroupRepository.findAll();
		
		return repoProductGroups.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
	}

	public List<ProductDTO> getProducts(int groupId) {
		List<Product> repoUserProducts = productRepository.findByUserId(1);
		
		List<Product> userProducts = repoUserProducts.stream()
				.filter(p -> p.getGroup().getId() == groupId)
				.collect(Collectors.toList());
		
		return userProducts.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
	}

	private ProductGroupDTO convertToDTO(ProductGroup productGroup) {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(productGroup, ProductGroupDTO.class);
    }
    
    private ProductDTO convertToDTO(Product product) {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(product, ProductDTO.class);
    }
	

}
