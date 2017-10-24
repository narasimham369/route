package com.route21.ws.constants;

/**
 * 
 * @author Uthirapathi This class is a Constant class for URI
 *
 */
public interface EmailConstants {	
	
	//String BASE_URL = "http://52.16.211.232:3000";
	//String BASE_URL = "http://52.209.112.67:3000";
	String BASE_URL = "https://route21.org";
	
	String FORGOT_PWD_SUB = "Route 21 - Forgot password";
	String AUTHORIZE_EMPLOYEER = "Route 21 - your account is active!";
	String REGISTERATION_SUB = "Route21 - welcome ";
	String REGISTERATION_ADMIN = "Route 21 - new employer sign up";
	String APPLYINGJOB_STUDENT = "Route 21 – your application has been sent to ";
	String APPLYINGJOB_EMPLOYER = " has applied for your opportunity";
	String CONTACT_SUB = "Route 21 - New enquiry";
	
	
	String FACEBOOK_URL = "https://www.facebook.com/";
	String TWITTER_URL = "https://twitter.com/";
	String INSTAGRAM_URL = "https://www.instagram.com/";
	
	String UNSUBSCRIBE = BASE_URL+"/faq";
	String PRIVACY_POLICY = BASE_URL+"/privacy-policy";
	String TERMS_AND_CONDITIONS = BASE_URL+"/terms-of-use";
	
	String SIGN_IN = BASE_URL+"/login";	
	String RESET_LINK = BASE_URL+"/reset-password?reset=";
	String PROFILE = BASE_URL;
	String DASHBOARD = BASE_URL;
	String STORIES = BASE_URL+"/inspiration";
	
	String STUDENTPROFILE_LINK = BASE_URL+"/students-detail/";
	String OPPORTUNITY_LINK = BASE_URL+"/oppoptunity-details/";
	

}