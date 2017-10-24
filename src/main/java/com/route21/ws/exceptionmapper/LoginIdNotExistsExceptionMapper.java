package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.LoginIdNotExistsException;

@Provider
public class LoginIdNotExistsExceptionMapper implements ExceptionMapper<LoginIdNotExistsException> {

	@Override
	public Response toResponse(LoginIdNotExistsException exception) {
		ErrorDetails errorDetails = new ErrorDetails("Email not exists",
				exception.getMessage(), "401", "link");
		return Response.status(Status.FOUND).entity(errorDetails).build();		
	}

}
