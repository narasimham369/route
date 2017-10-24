package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.LoginCredentialNotMatchedException;


@Provider
public class LoginCredentialNotMatchedExceptionMapper implements ExceptionMapper<LoginCredentialNotMatchedException> {

	@Override
	public Response toResponse(LoginCredentialNotMatchedException exception) {
		ErrorDetails errorDetails = new ErrorDetails("Login Credential not matched",
				exception.getMessage(), "401", "link");
		return Response.status(Status.UNAUTHORIZED).entity(errorDetails).build();		
	}

}
