package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.NotAuthorizedException;

@Provider
public class NotAuthorizedExceptionMapper implements ExceptionMapper<NotAuthorizedException>{

	@Override
	public Response toResponse(NotAuthorizedException exception) {
		ErrorDetails errorDetails = new ErrorDetails("Please login with valid credentials.",
				exception.getMessage(), "401", "link");
		return Response.status(Status.UNAUTHORIZED).entity(errorDetails).build();
	}

}
