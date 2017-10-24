package com.route21.ws.endpoint;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.bean.Category;
import com.route21.ws.bean.OpportunityType;
import com.route21.ws.bean.Qualification;
import com.route21.ws.request.LookupDataRequest;
import com.route21.ws.service.ActivityTypeService;
import com.route21.ws.service.CategoryService;
import com.route21.ws.service.OpportunityService;
import com.route21.ws.service.OpportunityTypeService;
import com.route21.ws.service.QualificationService;

/**
 * 
 * This class gives lookup data of party.
 * 
 * @author admin-pc
 *
 */
@RestController
@Path("/")
public class Route21LookupController {

	private static final Logger LOGGER = LoggerFactory.getLogger(Route21LookupController.class);
	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	QualificationService qualificationService;

	@Autowired
	ActivityTypeService activityTypeService;

	@Autowired
	OpportunityTypeService opportunityTypeService;
	
	@Autowired
	CategoryService categoryService;

	/**
	 * 
	 * This method is used to add LookupData of qualification or activity type or opportunity or category..
	 *  
	 * @param request contains attributes of {@link LookupDataRequest}.
	 * 
	 * @param1 httpServletRequest to get request of HttpServlet.
	 * 
	 */

	@POST
	@Path("/lookupData/{a:qualification|activitytype|opportunitytype|category}")
	@Produces("application/json")
	@Consumes("application/json")
	public Object addLookupData(@Context HttpServletRequest httpServletRequest, LookupDataRequest request) {

		String url = httpServletRequest.getRequestURI();
		if (url.contains("/qualification")) {
			LOGGER.info("reached controller");
			Qualification q = new Qualification();
			q.setName(request.getName());
			return qualificationService.addQualification(q);
		} else if (url.contains("/activitytype")) {
			ActivityType at = new ActivityType();
			at.setType(request.getType());
			return activityTypeService.addActivityType(at);
		} else if (url.contains("/opportunitytype")) {
			OpportunityType ot = new OpportunityType();
			ot.setType(request.getType());
			return opportunityTypeService.addOpportunityType(ot);
		} else if (url.contains("/category")){
			Category c= new Category();
			c.setName(request.getName());
			return categoryService.addCategory(c);
		}
		else 
			return null;

	}

	/**
	 * 
	 * This controller is used to update LookupData.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param request
	 *            to hold the records.
	 * 
	 * @param1 httpServletRequest to get http request.
	 * 
	 */

	@PUT
	@Path("/lookupData/{a:qualification|activitytype|opportunitytype|category}")
	@Produces("application/json")
	@Consumes("application/json")
	public Object updateLookupData(@Context HttpServletRequest httpServletRequest, LookupDataRequest request) {
		String url = httpServletRequest.getRequestURI();
		if (url.contains("/qualification")) {
			Qualification q = new Qualification();
			q.setId(request.getId());
			q.setName(request.getName());
			return qualificationService.updateQualification(q);
		} else if (url.contains("/activitytype")) {
			ActivityType at = new ActivityType();
			at.setId(request.getId());
			at.setType(request.getType());
			return activityTypeService.updateActivityType(at);
		} else if(url.contains("/opportunitytype")){
			OpportunityType ot= new OpportunityType();
			ot.setId(request.getId());
			ot.setType(request.getType());	
			return opportunityTypeService.updateOpportunityType(ot);
		}else if(url.contains("/category")){
			Category c= new Category();
			c.setId(request.getId());
			c.setName(request.getName());
			return categoryService.updateCategory(c);
			
		}else
			
			return null;

	}

	/**
	 * 
	 * This controller is used to get LookupData.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param httpServletRequest
	 *            to get http servlet request.
	 * 
	 */

	@GET
	@Path("/lookupData/{a:qualification|activitytype|opportunitytype|category}")
	@Produces("application/json")
	public Object getLookupData(@Context HttpServletRequest httpServletRequest) {
		String url = httpServletRequest.getRequestURI();
		if (url.contains("/qualification")) {
			return qualificationService.getQualification();
		} else if (url.contains("/activitytype")) {
			return activityTypeService.getActivityType();
		} else if(url.contains("/opportunitytype")){
			return opportunityTypeService.getOpportunityType();
		} else if(url.contains("category")){
			return categoryService.getCategory();
		}else
			
			return null;

	}

	/**
	 * 
	 * This controller is used to delete LookupData.
	 * 
	 * In side the method it have only return type.
	 * 
	 * @param id
	 *            to delete records with id.
	 * 
	 * @param1 httpServletRequest to get http servlet request.
	 * 
	 */

	@DELETE
	@Path("/lookupData/{a:qualification|activitytype|opportunitytype|category}/{id}")
	@Produces("application/json")
	public Object deleteLookupData(@Context HttpServletRequest httpServletRequest, @PathParam("id") Long id) {
		String url = httpServletRequest.getRequestURI();
		if (url.contains("/qualification")) {
			return qualificationService.deleteQualification(id);
		} else if (url.contains("/activitytype")) {
			return activityTypeService.deleteActivityType(id);
		} else if(url.contains("/opportunitytype"))
		return opportunityTypeService.deleteOpportunityType(id);
		
		else if(url.contains("/category"))
		{
			return categoryService.deleteCategory(id);
		}else
			return null;

	}
}
