package com.route21.ws.endpoint;

import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.glassfish.jersey.internal.util.Base64;
import org.jose4j.json.internal.json_simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.annotation.JWTSecured;
import com.route21.ws.annotation.Secured;
import com.route21.ws.constants.Route21Constants;
import com.route21.ws.helper.JWTokenUtility;
import com.route21.ws.request.LoginRequest;
import com.route21.ws.request.ResetPasswordRequest;
import com.route21.ws.request.SampleRequest;
import com.route21.ws.request.UserStatusRequest;
import com.route21.ws.response.RegisterPartyResponse;
import com.route21.ws.response.RegisteredPartyListResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.UserLoginService;
import com.route21.ws.types.Role;

/**
 * This class gives the information about the login user.
 * 
 * @author admin-pc
 *
 */
@RestController
@Path("/")
public class UserLoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	protected UserLoginService userLoginService;
	
		

	
	/**
	 * 
	 * This method always returns response of object immediately.
	 * 
	 *  If user logged in successfully, it says processed successfully.
	 * 
	 * @return The response of the specified object.
	 * 
	 * @throws ParseException 
	 * 
	 */
	@GET
	@Produces("application/json")
	@Path("/User")	
	@JWTSecured({Role.STUDENT, Role.EMPLOYER})
	public Response test(@Context HttpServletResponse response,  @Context HttpServletRequest req) throws ParseException
	{
	   /* String info = uriInfo.getAbsolutePath().toString();
	    System.out.println("========="+info);*/
		Long id = JWTokenUtility.Jwtdecoder(req);
		System.out.println("id :::::"+id);
	   	Response res = new Response();
		res.setStatusCode(200);
		res.setStatusMessage("Processed Successfully");
		return res;
	}	
	
	
	@POST
	@Path("/User")
	@Produces("application/json")
	@Consumes("application/json")
	@Secured
	public Response test2(SampleRequest request)
	{		
		Response res = new Response();
		res.setStatusCode(200);
		res.setStatusMessage("ID::::"+request.getId()+"Name:::"+request.getName());
		return res;
		
	}
	
	/**
	 * 
	 * This method tells whether the user logged in successfully or not.
	 * 
	 * @param request the string to save login id and password.
	 * 
	 * @return login user successfully logged in or not.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.USER_LOGIN)
	@Produces("application/json")
	@Consumes("application/json")
	@Secured
	public RegisterPartyResponse userLogin(@Context HttpServletResponse httpresponse,@Context HttpServletRequest httprequest)
	{
		System.out.println("reached controller");
	    String authheader = httprequest.getHeader("Authorization");
	    String encodedUserPassword = authheader.replaceFirst("Basic ", "");
        
        String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
        
        StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
        String username = tokenizer.nextToken();
        String password = tokenizer.nextToken();
        
        LoginRequest request = new LoginRequest();
        request.setLoginId(username);
        request.setLoginPwd(password);
        System.out.println("ended controller");
		return userLoginService.userLogin(request,httpresponse);
		
		
	}
	

	/**
	 * 
	 * This method describes that user forgot his password at any time,then it will be executed.
	 *  
	 * @param request used for remembering temporary password.
	 * 
	 * @return the status of response object.
	 * 
	 */
	@PUT
	@Path(Route21Constants.USER_FORGOT)
	@Produces("application/json")
	@Consumes("application/json")
	public Response userForgotPwd(LoginRequest request) {
		LOGGER.info("USER FORGOT");
		return userLoginService.userForgotPwd(request);
	}
	
	/**
	 * 
	 * This method illustrates that user want to reset the password.
	 * 
	 * @param request to save reset password.
	 * 
	 * @return the response object to give the status.
	 * 
	 */
	@PUT
	@Path(Route21Constants.RESET_PASSWORD)
	@Produces("application/json")
	@Consumes("application/json")
	public RegisterPartyResponse resetPassword(ResetPasswordRequest request)
	{
		return userLoginService.resetPassword(request);		
	}
	
	/**
	 * 
	 * This method List out the users who has already registered.
	 * 
	 * @return the List object of registered users.
	 * 
	 */
	
	@GET
	@Path(Route21Constants.GET_CUSTOMER)
	@Produces("application/json")
	public RegisteredPartyListResponse getUserList()
	{
		return userLoginService.getUserList();
	}
	
	/**
	 * 
	 * This method List out the user details by id.
	 * 
	 * @param id By id we can get details.
	 * 
	 * @return the List object of registered users.
	 * 
	 */
	

	@GET
	@Path(Route21Constants.GET_CUSTOMERBY_ID)
	@Produces("application/json")
	public Response getUserById(@PathParam("id") long id)
	{

		return userLoginService.getUserById(id);
	}
	

	/**
	 * this method used to update the status of customer.
	 * 
	 * @param request to update the status.
	 * 
	 * @return the response object.
	 */
	@JWTSecured(Role.ADMIN)
	@PUT
	@Path(Route21Constants.UPDATE_CUSTOMER_STATUS)
	@Produces("application/json")
	@Consumes("application/json")
	public Response updateUserStatus(UserStatusRequest request)
	{
		return userLoginService.updateUserStatus(request);
		
	}
	
	@Path(Route21Constants.ADMIN)
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response lifeRayAdmin(LoginRequest request, @Context HttpServletResponse httpresponse){
		
		return userLoginService.lifeRayAdmin(request, httpresponse);
	}

}
