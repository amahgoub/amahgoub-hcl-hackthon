package com.ing.hackthon.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackthon.exceptions.InvalidProductException;
import com.ing.hackthon.productGroup.ProductGroupDTO;

import java.util.List;

/**
 * Rest Controller for handling product and productGroups requests.
 */
@RestController
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
    /**
     * This method handle the request for getting all the product groups
     * @return all the product groups
     * @throws InvalidProductException in case of service access exceptions
     */
    @GetMapping("/productGroups")
    public List<ProductGroupDTO> getAllProductGroups() throws InvalidProductException {
    	logger.debug("inside getAllProductGroups");
    	
        return productService.getAllProductGroups();
    }
    
    /**
     * This method handle the request for getting all the products under specific group for the logged in user
     * @param groupId to return only the products under the specified group 
     * @return only the products under the specified group 
     * @throws InvalidProductException in case of service access exceptions
     */
    @GetMapping("/products/{groupId}")
    public List<ProductDTO> getProducts(@PathVariable int groupId) throws InvalidProductException {
    	logger.debug("inside getProducts");
    	
    	return productService.getProducts(groupId);
    }
    
    

}


