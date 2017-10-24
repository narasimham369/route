package com.route21.ws.constants;

/**
 * 
 * @author Uthirapathi This class is a Constant class for URI
 *
 */
public interface Route21Constants {
	
	//content services
	String SAVE_CONTENT = "/Content";
	String GET_CONTENT = "/Content/{pageUrl}";
	String LIST_CONTENT = "/Content";
	
	String REGISTER_PARTY = "/Customer";	
	String UPDATE_PARTY = "/Customer/{id}";
	String USER_LOGIN = "/Customer/Login"; 
	String USER_FORGOT = "/Customer/ForgottenPassword"; 
	String RESET_PASSWORD = "/Customer/ResetPassword";
	String GET_CUSTOMER = "/Customer";
	String GET_CUSTOMERBY_ID = "/Customer/{id}";
	String UPDATE_CUSTOMER_STATUS="/Customer";
	String ADMIN="/liferayAdmin";
	
	String SAVE_STORY = "/Story";
	String UPDATE_STORY = "/Story";
	String DELETE_STORY = "/Story/{id}";
	String GET_STORY = "/Story";
	String GET_STORY_BY_ID = "/Story/{id}";
	
	String SAVEPARTY_QUALIFICATION = "/Customer/Qualification";
	String UPDATEPARTY_QUALIFICATION = "/Customer/Qualification/{id}";
	String GET_QUALIFICATIONBY_PARTYID = "/Customer/Qualification/{partyId}";
	String DELETE_QUALIFICATIONBY_ID = "/Customer/Qualification/{id}/{partyId}";
	
	
	String SAVEPARTY_ACTIVITY = "/Customer/Activity";
	String UPDATEPARTY_ACTIVITY = "/Customer/Activity/{id}";
	String GETPARTY_ACTIVITYBY_PARTYID = "/Customer/Activity/{partyId}";
	String DELETE_PARTYACTIVITYBY_ID = "/Customer/Activity/{id}/{partyId}";
	
	
	String SAVE_OPPORTUNITY = "/Opportunity";
	String UPDATE_OPPORTUNITY = "/Opportunity/{id}";
	String GET_OPPORTUNITY = "/Opportunity";
	
	
	String SAVEAPPLY_OPPORTUNITY = "/Opportunity/Apply";
	String UPDATEAPPLY_OPPORTUNITY = "/Opportunity/Apply/{id}";
	String GETAPPLY_OPPORTUNITY= "/Opportunity/Apply";
	String GETAPPLY_OPPORTUNITYBYPTYID= "/Opportunity/Apply/{ptyId}";
	String DELETEAPPLY_OPPORTUNITYBY_ID= "/ApplyOpportunity/{id}";
	
	String SAVE_EXPERIENCE = "/Customer/Experience";
	String UPDATE_EXPERIENCE = "/Customer/Experience/{id}";
	String GET_EXPERIENCE = "/Customer/Experience/{partyId}";
	String DELETEEXPERIENCE_BYID = "/Customer/Experience/{id}/{partyId}";
	
	//contact service
	String CONTACT_US = "/Enquiry";
	String LIST_CONTACT = "/Enquiry";
	
	String ORGANDINSPARTY_LIST = "/Party";

	String SAVE_MENU = "/Menu";
	String LIST_MENU = "/Menu";
	String GET_MENU  = "/Menu/{Id}";
	String DELETE_MENU = "Menu/{Id}";
	
	

}