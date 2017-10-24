package com.route21.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.ActivityType;
import com.route21.ws.repository.ActivityTypeRepository;
import com.route21.ws.response.ActivityTypeListResponse;
import com.route21.ws.response.ActivityTypeResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.ActivityTypeService;
import com.route21.ws.service.OpportunityService;

/**
* 
* This class gives Activity Type details.
* 
* @author admin-pc
*/

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService{
	/**
	 * It inject {@link OpportunityService} object
	 */
	@Autowired
	ActivityTypeRepository activityTypeRepository;
	
	/**
	 * 
	 * This  method is used to insert data into ActivityType table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param at contains attribute of {@link ActivityType}
	 *
	 * @return the response status message
	 * 
	 */
	@Override
	public ActivityTypeResponse addActivityType(ActivityType at) {

		ActivityTypeResponse response = new ActivityTypeResponse();
		ActivityType newActivitytype = activityTypeRepository.save(at);
		response.setActivityType(newActivitytype);
		response.setStatusCode(200);
		response.setStatusMessage("SUCESSFULLY INSERTED");
		return response;
	}

	/**
	 * 
	 * This  method is used to update data into ActivityType table.
	 * 
	 * This method consists of business logic which is used to update details of ActivityType table.
	 * 
	 * @param at contains attributes of {@link ActivityType}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public ActivityTypeResponse updateActivityType(ActivityType at) {
		ActivityTypeResponse response = new ActivityTypeResponse();
		ActivityType activitytype = activityTypeRepository.findOne(at.getId());
		
		activitytype.setType(at.getType());
		ActivityType updatedType = activityTypeRepository.save(activitytype);
		response.setActivityType(updatedType);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to get data from ActivityType table.
	 * 
	 * This method consists of business logic which is used to get details of ActivityType table.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public ActivityTypeListResponse getActivityType() {

		ActivityTypeListResponse response = new ActivityTypeListResponse();
		List<ActivityType> lstActivitytype = activityTypeRepository.findAll();
		response.setLstActivityType(lstActivitytype);
		response.setStatusCode(200);
		response.setStatusMessage("RETREIVED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to delete data from ActivityType table.
	 * 
	 * This method consists of business logic which is used to delete details of ActivityType table.
	 * 
	 * @param id contains id of ActivityType.
	 * 
	 * @return the response status message
	 * 
	 */
	@Override
	public Response deleteActivityType(Long id) {

		Response response = new Response();
		try
		{
			activityTypeRepository.delete(id);
			response.setStatusCode(200);
			response.setStatusMessage("DELETED SUCCESSFULLY");
		}
		catch(Exception ex)
		{
			response.setStatusCode(500);
			response.setStatusMessage("INTERNAL SERVER ERROR");
		}
		return response;
	}

}
