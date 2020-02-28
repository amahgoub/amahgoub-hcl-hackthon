package com.ing.hackthon.exceptions;

/**
 * This class for holding the error message details and presented as a json, xml, ..etc in the response by the exception handler
 *
 */
public class ErrorMessage {

	private String code;
	private String message;
	
	public ErrorMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
