package com.ing.hackthon.productDetails;

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


/**
 * Service for providing product details data
 */
@Service
public class ProductDetailsService {

	private static Logger logger = LoggerFactory.getLogger(ProductDetailsService.class);

	
	@Autowired
	private ProductDetailsRepository productDetailsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * This method for returning product details for specific product id
	 * @param id the product id 
	 * @return the product details DTOs
	 * @throws InvalidProductException in case of access product details service exceptions
	 */
	public List<ProductDetailsDTO> getProductDetails(int id) throws InvalidProductException {	
		logger.debug("getProductDetails method starts processing with product id: " + id);
		
		
		try {
			List<ProductDetails> productDetailsList = productDetailsRepository.findByProductId(id);
			
			return productDetailsList.stream()
					.map(this::convertToDTO)
					.collect(Collectors.toList());
		} catch (DataAccessException e) {
			throw new InvalidProductException(new ErrorMessage(ErrorMessageCode.SERVICE_UNAVAILABLE.getCode(), "Product Details Service unreachable"));
		}
	}
	
	/**
	 * Method for converting product details domain object to ProductDetailsDTp
	 * @param product details domain object
	 * @return product details DTO
	 */
	private ProductDetailsDTO convertToDTO(ProductDetails productDetails) {
    	return modelMapper.map(productDetails, ProductDetailsDTO.class);
    }
}
