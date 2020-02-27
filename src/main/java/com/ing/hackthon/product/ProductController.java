package com.ing.hackthon.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;
    
    /**
     * 
     * @return
     */
    @GetMapping("/productGroups")
    public List<ProductGroupDTO> getAllProductGroups() {
    	logger.debug("inside getAllProductGroups");
    	
        return productService.getAllProductGroups();
    }
    
    /**
     * @param groupId
     * @return
     */
    @GetMapping("/products/{groupId}")
    public List<ProductDTO> getProducts(@PathVariable int groupId) {
    	logger.debug("inside getProducts");
    	
    	return productService.getProducts(groupId);
    }
    
    

}


