package com.cts.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDetails {
//	@JsonProperty
//	private LocalDateTime timestamp;
	@JsonProperty
	private String message;
	@JsonProperty
	private String details;

	public ErrorDetails() {
		// TODO Auto-generated constructor stub
	}

	public ErrorDetails(String message, String details) { // LocalDateTime timestamp,
		super();
		// this.timestamp = timestamp;
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
