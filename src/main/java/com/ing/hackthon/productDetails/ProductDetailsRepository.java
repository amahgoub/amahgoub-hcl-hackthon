package com.ing.hackthon.productDetails;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	List<ProductDetails> findByProductId(int productId);
}
