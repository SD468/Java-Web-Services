package com.cts.exception;

public class MarksheetNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MarksheetNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

	public MarksheetNotFoundException(String message) {
		super(message);
	}

}
