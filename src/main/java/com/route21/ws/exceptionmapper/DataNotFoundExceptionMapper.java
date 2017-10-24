package com.route21.ws.exceptionmapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.route21.ws.error.ErrorDetails;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.LiferayException;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<Exception> {
	ErrorDetails errorDetails;
	@Override
	public Response toResponse(Exception exception) {
		if(exception instanceof DataNotFoundException){
		 errorDetails = new ErrorDetails("Data not Found",
				exception.getMessage(), "404", "link");		
		}
		else if(exception instanceof LiferayException){
			errorDetails = new ErrorDetails("LiferayException",
					exception.getMessage(), "404", "link");	
		}
		return Response.status(Status.NOT_FOUND).entity(errorDetails).build();
	}
	
	
	
}
