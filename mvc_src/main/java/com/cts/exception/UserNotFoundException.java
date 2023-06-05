package com.cts.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}
