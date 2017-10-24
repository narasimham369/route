package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.EmailAlreadyRegisteredException;

@Provider
public class EmailAlreadyRegisteredExceptionMapper implements ExceptionMapper<EmailAlreadyRegisteredException> {

	@Override
	public Response toResponse(EmailAlreadyRegisteredException exception) {
		ErrorDetails errorDetails = new ErrorDetails("Email already Registered",
				exception.getMessage(), "400", "link");
		return Response.status(Status.BAD_REQUEST).entity(errorDetails).build();			
	}

}
