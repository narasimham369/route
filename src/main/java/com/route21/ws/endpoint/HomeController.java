package com.route21.ws.endpoint;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

import com.route21.ws.constants.EmailConstants;
import com.route21.ws.response.Response;
import com.route21.ws.util.EmailHtmlSender;
import com.route21.ws.util.EmailStatus;


/**
* 
* This class gives information about signup the customer.
* 
* @author admin-pc
*
*/
@RestController
@Path("/")
public class HomeController {
	
	
	
	@Autowired
	protected EmailHtmlSender emailHtmlSender;

	
	/**
	 * 
	 * This test method is used to test the e-mail address.
	 * 
	 * @throws UnsupportedEncodingException.
	 * 
	 * @return saveContent object to save the records in database.
	 * 
	 */
	
	@GET
	@Produces("application/json")
	@Path("/test")
	public Response test() throws UnsupportedEncodingException
	{
		Response res = new Response();
		System.out.println("Encryption Test");
		
		
		Context context = new Context();
		context.setVariable("firstname", "Uthirapathi");
		context.setVariable("lastname", "Devendran");
		context.setVariable("middlename", "middle");
		context.setVariable("email", "uthirapathi@madebyfire.com");
		context.setVariable("message", "Enquiry message");
		
		context.setVariable("password", "123456789");
		context.setVariable("name", "uthirapathi");
		
		context.setVariable("profile", EmailConstants.PROFILE);
		context.setVariable("dashboard", EmailConstants.PROFILE);
		context.setVariable("signin", EmailConstants.PROFILE);
		
		context.setVariable("site_url", EmailConstants.BASE_URL);
		context.setVariable("link", EmailConstants.RESET_LINK+"312kk3k23j452j3h5j245");
		
		//EmailStatus emailStatus2 = emailHtmlSender.send("uthirapathi@madebyfire.com", "Route21 - email test", "email/contact-us", context);
		
		EmailStatus emailStatus = emailHtmlSender.send("uthirapathi@madebyfire.com", "Route21 - email test", "email/register", context);
		
		EmailStatus emailStatus1 = emailHtmlSender.send("uthirapathi@madebyfire.com", "Route21 - email test", "email/forgot-password", context);
		
		System.out.println("ERROR MESSAGE DETAILS "+emailStatus.getErrorMessage());
		System.out.println("EMAIL STATUS "+emailStatus.getStatus());	
		
		/*String str = "uthirapathi@madebyfire.com|123456789";
		byte[]   bytesEncoded = Base64.getEncoder().encode(str.getBytes("utf-8"));
		System.out.println("ecncoded value is " + new String(bytesEncoded ));*/
		
		res.setStatusCode(200);
		res.setStatusMessage("Processed Successfully");
		return res;
	}	
	
	
	
}
