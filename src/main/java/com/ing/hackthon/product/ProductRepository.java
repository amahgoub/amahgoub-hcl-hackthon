package com.ing.hackthon.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for products
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	/**
	 * This method should return all the Products has the specified group id
	 * @param groupId to filter the products
	 * @return all the Products has the specified group id
	 */
	List<Product> findByGroupId(Integer groupId);
	
	/**
	 * This method should return all the Products has the specified user id
	 * @param userId to filter the products
	 * @return all the Products has the specified user id
	 */
	List<Product> findByUserId(Integer userId);

}
