package com.ing.hackthon.productDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for product details 
 */
@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	/**
	 * Method for returning product details associated with the given productId
	 * @param productId of the associated product
	 * @return product details
	 */
	List<ProductDetails> findByProductId(int productId);
}
