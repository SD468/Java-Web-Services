package com.cts.rest.exception;

public class ErrorDetails {

	//private LocalDateTime timestamp;
	private String message;
	private String details;

	public ErrorDetails( String message, String details) {
		super();
		//this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

//	public LocalDateTime getTimestamp() {
//		return timestamp;
//	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	

}
















