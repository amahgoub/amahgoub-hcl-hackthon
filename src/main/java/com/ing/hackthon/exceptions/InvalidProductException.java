package com.ing.hackthon.exceptions;

/**
 * A General product exception for product, productGroup and productDetails invalidation exceptions
 */
public class InvalidProductException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private final ErrorMessage errorMessage;
	
	public InvalidProductException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	
	
	
	
	
}
