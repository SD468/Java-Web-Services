package com.cts.rs.ws.exception;


import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BillNotFoundExceptionMapper implements ExceptionMapper<BillNotFoundException>{

	@Override
	public Response toResponse(BillNotFoundException exception) {
		ErrorResponse errorResponse=new ErrorResponse();
		errorResponse.setErrorMsg(exception.getMessage());
		errorResponse.setStatusCode(422);
		return Response.status(422).entity(errorResponse).build();
	}
	

}
