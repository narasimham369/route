package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.EmployerNotApprovedException;

@Provider
public class EmployerNotApprovedExceptionMapper implements ExceptionMapper<EmployerNotApprovedException>{

	@Override
	public Response toResponse(EmployerNotApprovedException exception) {
	
		ErrorDetails errorDetails = new ErrorDetails("Admin not approved your account",
				exception.getMessage(), "400", "link");
		return Response.status(Status.BAD_REQUEST).entity(errorDetails).build();	
	}

}
