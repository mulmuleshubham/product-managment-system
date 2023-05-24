package com.product.exception;



public class IdNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1450278795149800657L;

	

	private String message;

	public IdNotFoundException(String message) {
		super();
		
		this.message = message;
	}

	

	public String getMessage() {
		return message;
	}
}
