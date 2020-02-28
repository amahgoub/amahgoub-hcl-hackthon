package com.ing.hackthon.product;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.ing.hackthon.exceptions.ErrorMessage;
import com.ing.hackthon.exceptions.ErrorMessageCode;
import com.ing.hackthon.exceptions.InvalidProductException;
import com.ing.hackthon.productGroup.ProductGroup;
import com.ing.hackthon.productGroup.ProductGroupDTO;
import com.ing.hackthon.productGroup.ProductGroupRepository;

/**
 * Service for providing product groups and products data
 */
@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductGroupRepository productGroupRepository;
	
	/**
	 * Model mapper for mapping domain objects to DTOs
	 */
	@Autowired
	private ModelMapper modelMapper;
	
	/**
     * This method handle the request for getting all the product groups
     * @return all the product groups
     * @throws InvalidProductException in case of service access exceptions
     */
	public List<ProductGroupDTO> getAllProductGroups() throws InvalidProductException {
		logger.debug("getAllProductGroups method start processing");
		
		try {
			List<ProductGroup> repoProductGroups = productGroupRepository.findAll();

			return repoProductGroups.stream()
	        		.map(this::convertToDTO)
	        		.collect(Collectors.toList());
			
		} catch (DataAccessException e) {
			throw new InvalidProductException(new ErrorMessage(ErrorMessageCode.SERVICE_UNAVAILABLE.getCode(), "Group Service unreachable"));
		}
	}

	/**
     * This method handle the request for getting all the products under specific group for the logged in user
     * @param groupId to return only the products under the specified group 
     * @return only the products under the specified group 
     * @throws InvalidProductException in case of service access exceptions
     */
	public List<ProductDTO> getProducts(int groupId) throws InvalidProductException {
		logger.debug("getProducts method start processing with groupId : " + groupId);
		
		try {
			List<Product> repoUserProducts = productRepository.findByUserId(1); // assume the logged in user has Id 1
			
			List<Product> userProducts = repoUserProducts.stream()
					.filter(p -> p.getGroup().getId() == groupId)
					.collect(Collectors.toList());
			
			return userProducts.stream()
					.map(this::convertToDTO)
					.collect(Collectors.toList());
		
		} catch (DataAccessException e) {
			throw new InvalidProductException(new ErrorMessage(ErrorMessageCode.SERVICE_UNAVAILABLE.getCode(), "Product Service unreachable"));
		} 
	}

	/**
	 * Method for converting product group domain object to ProductGroupDTp
	 * @param productGroup domain object
	 * @return productGroup DTO
	 */
	private ProductGroupDTO convertToDTO(ProductGroup productGroup) {
    	return modelMapper.map(productGroup, ProductGroupDTO.class);
    }
    
	/**
	 * Method for converting product  domain object to ProductDTp
	 * @param product domain object
	 * @return product DTO
	 */
    private ProductDTO convertToDTO(Product product) {
    	return modelMapper.map(product, ProductDTO.class);
    }
	

}
