package com.route21.ws.exceptionmapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.route21.ws.error.ErrorDetails;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
       
    	final StringBuilder strBuilder = new StringBuilder();
        
        for (ConstraintViolation<?> cv : (exception).getConstraintViolations()) {
            strBuilder.append(cv.getMessage()).append(", ");
        }        
        ErrorDetails errorDetails = new ErrorDetails("Datavalidation exception",
        		strBuilder.toString(), "404", "link");
		return Response.status(Status.BAD_REQUEST).entity(errorDetails).build();
    }
    
}