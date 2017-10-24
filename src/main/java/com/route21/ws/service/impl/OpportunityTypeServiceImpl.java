package com.route21.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.OpportunityType;
import com.route21.ws.repository.OpportunityTypeRepository;
import com.route21.ws.response.OpportunityTypeListResponse;
import com.route21.ws.response.OpportunityTypeResponse;
import com.route21.ws.response.Response;
import com.route21.ws.service.OpportunityTypeService;

/**
* 
* This class gives OpportunityType details of party.
* 
* @author admin-pc
*
*/
@Service
public class OpportunityTypeServiceImpl implements OpportunityTypeService{

	/**
	 * It inject {@link OpportunityType Service} object
	 */
	@Autowired
	OpportunityTypeRepository opportunityTypeRepository;
	
	/**
	 * 
	 * This  method is used to insert data into OpportunityType table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param ot contains attribute of {@link OpportunityType}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public OpportunityTypeResponse addOpportunityType(OpportunityType ot) {

		
		OpportunityTypeResponse response = new OpportunityTypeResponse();
		OpportunityType newopntyType = opportunityTypeRepository.save(ot);
		
		response.setOpportunitytype(newopntyType);
		response.setStatusCode(200);
		response.setStatusMessage("SUCESSFULLY INSERTED");
		return response;
	}
	
	/**
	 * 
	 * This  method is used to update data into OpportunityType table.
	 * 
	 * This method consists of business logic which is used to update details of OpportunityType table.
	 * 
	 * @param ot contains attributes of {@link OpportunityType}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public OpportunityTypeResponse updateOpportunityType(OpportunityType ot) {

		
		OpportunityTypeResponse response = new OpportunityTypeResponse();
		OpportunityType opportunityType= opportunityTypeRepository.findOne(ot.getId());
		opportunityType.setType(ot.getType());
		OpportunityType updatedOpportunity = opportunityTypeRepository.save(opportunityType);
		response.setOpportunitytype(updatedOpportunity);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		return response;
	}

	/**
	 * 
	 * This  method is used to get data from OpportunityType table.
	 * 
	 * This method consists of business logic which is used to get details of OpportunityType table.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public OpportunityTypeListResponse getOpportunityType() {

		
		OpportunityTypeListResponse resp= new OpportunityTypeListResponse();
		List<OpportunityType> lstOpportunityType =opportunityTypeRepository.findAll();
		resp.setLstOpportuniyType(lstOpportunityType);
		resp.setStatusCode(200);
		resp.setStatusMessage("RETRIEVED SUCCESSFULLY");
		return resp;
	}
	
	/**
	 * 
	 * This  method is used to delete data from OpportunityType table.
	 * 
	 * This method consists of business logic which is used to delete details of OpportunityType table.
	 * 
	 * @param id contains id of OpportunityType.
	 * 
	 * @return the response status message
	 * 
	 */
	
	@Override
	public Response deleteOpportunityType(Long id) {

		
		Response response= new Response();
		
		try
		{
			opportunityTypeRepository.delete(id);
			response.setStatusCode(200);
			response.setStatusMessage("DELETED SUCCESSFULLY");
		}
		catch(Exception e){
			
			response.setStatusCode(500);
			response.setStatusMessage("INTERNAL SERVER ERROR");
		}
		return response;
	}
	

}
