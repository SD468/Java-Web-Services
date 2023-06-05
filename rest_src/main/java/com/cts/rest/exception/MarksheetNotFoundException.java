package com.cts.rest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class MarksheetNotFoundException extends Exception {
	
	public MarksheetNotFoundException(String message, Exception cause) {
		super(message, cause);
	}

	public MarksheetNotFoundException(String message) {
		super(message);
	}

}
