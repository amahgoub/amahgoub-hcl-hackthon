package com.ing.hackthon.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
	private static Logger logger = LoggerFactory.getLogger(UserExceptionHandler.class);
	
	/**
	 * This method handles exception related to user invalidation
	 * @param exception the thrown user invalidation exception
	 * @return errorMessage object contains the error code and the error message to be displayed as json or XML in the response
	 */
	@ExceptionHandler
	public ErrorMessage invalidUserExceptionHandler(InvalidUserException exception) {
		logger.debug("Invalid user exception occurs " + exception.getMessage() );
		
		return exception.getErrorMessage();
	}
}
