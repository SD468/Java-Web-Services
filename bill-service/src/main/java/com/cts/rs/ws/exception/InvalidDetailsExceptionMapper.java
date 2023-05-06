package com.cts.rs.ws.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class InvalidDetailsExceptionMapper implements ExceptionMapper<InvalidDetailsException>{

	@Override
	public Response toResponse(InvalidDetailsException exception) {
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorMsg(exception.getMessage());
		errorResponse.setStatusCode(400);
		return Response.status(400).entity(errorResponse).build();
	}
}
