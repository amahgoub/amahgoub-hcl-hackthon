package com.ing.hackthon.exceptions;

/**
 * This enum for presenting all the used error codes when some exception occurs
 *
 */
public enum ErrorMessageCode {
	
	SERVICE_UNAVAILABLE("500"),
	INVALID_DATA("300");

	private String code;

	private ErrorMessageCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	
	
	
}
