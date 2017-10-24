package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.OperationProhibitedException;

@Provider
public class OperationProhibitedExceptionMapper implements ExceptionMapper<OperationProhibitedException>{

	@Override
	public Response toResponse(OperationProhibitedException exception) {
	
		
		ErrorDetails errorDetails = new ErrorDetails("you don't have authorities", 
				exception.getMessage(),"401", "link");
		
		return Response.status(Status.BAD_REQUEST).entity(errorDetails).build();
	}

}
