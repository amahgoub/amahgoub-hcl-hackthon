package com.ing.hackthon.productGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring JPA repository for product groups
 */
@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Integer>{

}
