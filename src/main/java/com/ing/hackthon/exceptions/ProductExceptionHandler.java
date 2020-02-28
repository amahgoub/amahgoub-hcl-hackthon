package com.ing.hackthon.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Exception handler for Product related exceptions
 */
@RestControllerAdvice
public class ProductExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(ProductExceptionHandler.class);
	
	
	/**
	 * This method handles exception related to product invalidation
	 * @param exception the thrown product invalidation exception
	 * @return errorMessage object contains the error code and the error message to be displayed as json or XML in the response
	 */
	@ExceptionHandler
	public ErrorMessage invalidProductExceptionHandler(InvalidProductException exception) {
		logger.debug("Invalid product exception occurs " + exception.getMessage() );
		
		return exception.getErrorMessage();
	}
	
}
