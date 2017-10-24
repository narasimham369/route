package com.route21.ws.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.security.Security;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.internal.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityFilterAutoConfiguration;

import com.route21.ws.annotation.Secured;
import com.route21.ws.bean.UserLogin;
import com.route21.ws.exception.NotAuthorizedException;
import com.route21.ws.exception.OperationProhibitedException;
import com.route21.ws.helper.EncryptDecrypt;
import com.route21.ws.repository.UserLoginRepository;
import com.route21.ws.request.LoginRequest;


/**
 * This class allows a user's request for further process by checking their authentication.
 * If authentication is succeed, it allows the user to access server resource. Otherwise it makes the server resource forbidden.
 * 
 */
@Secured
public class AuthenticationFilter implements ContainerRequestFilter{
	
	@Autowired
	private UserLoginRepository userLoginRepository;
	
	
	@Autowired
    protected EncryptDecrypt encryptDecrypt;

	@Context
	private ResourceInfo resourceInfo;
	
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
                                                        .entity("You cannot access this resource").build();
    private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
                                                        .entity("Access blocked for all users !!").build();
      
	/**
	 * This method will check the logged in users authentication and return true if user has an valid account credentials.
	 * Otherwise return false and make the resource forbidden.
	 * 
	 * @param requestContext A mutable object that provides request-specific information for the filter.
	 * @throws IOException It throws when unchecked IO error happens.
	 * @see javax.ws.rs.container.ContainerRequestFilter#filter "javax.ws.rs.container.ContainerRequestContext".
	 */
    
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		
	    
	    
		Method method = resourceInfo.getResourceMethod();
		
		
        
		if(! method.isAnnotationPresent(PermitAll.class))
		{
			
			if(method.isAnnotationPresent(DenyAll.class))
			{
				requestContext.abortWith(ACCESS_FORBIDDEN);
				return;
			}
			
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			
			
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
			
			if(authorization == null || authorization.isEmpty())
			{
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}
			
		
			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
			
			 String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
			 
			 final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			 final String username = tokenizer.nextToken();
	         final String password = tokenizer.nextToken();
	        
	        
            if( ! isUserAllowed(username, password))
            {
               
                throw new NotAuthorizedException("Please login with valid credentials.");
              
            }
		}
		
	}


	/**
	 * This method will check the logged in users authentication and return true if user has an account.
	 * 
	 * @param username A string as user name of party account.
	 * @param password A string as password of the party account.
	 * @param rolesSet A String may have the value of ADMIN or USER based on the account type.
	 * @return Return boolean value based on the party's account verification.
	 */
	private boolean isUserAllowed(String username, String password) {
		
		boolean isAllowed = false;
		
				
		UserLogin userLogin = userLoginRepository.findUserLogin(username,
                encryptDecrypt.encrypt(password));
		if(userLogin != null)
			isAllowed = true;
		else
			isAllowed = false;		
		        		
        return isAllowed;
    }
	
	
	
		
}