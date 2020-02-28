package com.ing.hackthon.exceptions;

/**
 * A General user related exception for user and userStatistics invalidation exceptions
 */
public class InvalidUserException extends Exception{

	private static final long serialVersionUID = 1L;

private final ErrorMessage errorMessage;
	
	public InvalidUserException(ErrorMessage errorMessage) {
		super(errorMessage.getMessage());
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
	
	
	
}
