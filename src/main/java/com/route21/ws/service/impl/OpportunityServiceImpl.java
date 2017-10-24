package com.route21.ws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.route21.ws.bean.Category;
import com.route21.ws.bean.Opportunity;
import com.route21.ws.bean.OpportunityType;
import com.route21.ws.bean.Party;
import com.route21.ws.bean.Qualification;
import com.route21.ws.endpoint.ExperienceController;
import com.route21.ws.exception.DataNotFoundException;
import com.route21.ws.exception.OperationProhibitedException;
import com.route21.ws.repository.CategoryRepository;
import com.route21.ws.repository.OpportunityRepository;
import com.route21.ws.repository.OpportunitySpecifications;
import com.route21.ws.repository.OpportunityTypeRepository;
import com.route21.ws.repository.PartyRepository;
import com.route21.ws.repository.PartyTypeRepository;
import com.route21.ws.repository.QualificationRepository;
import com.route21.ws.request.OpportunityRequest;
import com.route21.ws.request.OppurtunityBeanRequest;
import com.route21.ws.response.OpportunityListResponse;
import com.route21.ws.response.OpportunityResponse;
import com.route21.ws.service.OpportunityService;
import com.route21.ws.types.PartyTypeEnum;

/**
* 
* This class gives Opportunity details of party.
* 
* It throws exceptions like DataNotFoundException when user data not available.
* 
* @author admin-pc
*
*/
@Transactional
@Service
public class OpportunityServiceImpl implements OpportunityService{

	private static final Logger LOGGER = LoggerFactory.getLogger(OpportunityServiceImpl.class);
	/**
	 * It inject {@link OpportunityService} object
	 */
	
	@Autowired
	OpportunityRepository opportunityrepository;

	@Autowired
	PartyRepository ptyRepository;
	
	@Autowired
	PartyTypeRepository ptyTypeRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	OpportunityTypeRepository opportunityTypeRepository;
	
	@Autowired
	QualificationRepository qualificationRepository;

	

	/**
	 * 
	 * This  method is used to insert data into Opportunity table.
	 * 
	 * This method consists of business logic which is used to add details into table.
	 * 
	 * @param request contains attribute of {@link OpportunityRequest}
	 *
	 * @return the response status message
	 * 
	 */
	
	@Override
	public OpportunityResponse saveOpportunity(OpportunityRequest request) {

	
		Party pty = ptyRepository.findOne(request.getPartyId());
		
		if (pty == null) {
			throw new DataNotFoundException("Party not found");
		}
		else if(pty.getPartyType().getId() == PartyTypeEnum.Employer.value)
		{
			
		Category category = categoryRepository.findByName(request.getCategoryName());
		if(category == null)
		{
			category = new Category();
			category.setName(request.getCategoryName());
		}
		
		OpportunityType optType = opportunityTypeRepository.findByType(request.getOppurtunityName());		
		if(optType == null)
		{
			 optType = new OpportunityType();
			 optType.setType(request.getOppurtunityName());
		}

		Qualification qual= qualificationRepository.findByName(request.getQualificationName());
		if(qual == null)
		{
			qual = new Qualification();
			qual.setName(request.getQualificationName());
		}
		
		Opportunity opportunity = new Opportunity();		
		opportunity.setParty(pty);
		opportunity.setTitle(request.getTitle());
		opportunity.setLocation(request.getLocation());
		opportunity.setDesiredSkills(request.getDesiredSkills());
		opportunity.setType(request.getType());
		opportunity.setCategory(category);
		opportunity.setOpportunityType(optType);
		opportunity.setDescription(request.getDescription());
		opportunity.setHowToApply(request.getHowToApply());
		opportunity.setLinkRef(request.getLinkRef());
		opportunity.setStatus(request.getStatus());
		opportunity.setRole(request.getRole());
		opportunity.setDepartment(request.getDepartment());
		opportunity.setMinWage(request.getMinWage());
		opportunity.setLiveOrFuture(request.getLiveOrFuture());
		opportunity.setStartDate(request.getStartDate());
		opportunity.setEndDate(request.getEndDate());
		opportunity.setWageType(request.getWageType());
		opportunity.setDuration(request.getDuration());
		opportunity.setQualification(qual);
		opportunity.setMinAge(request.getMinAge());
		opportunity.setShortDescription(request.getShortDescription());
		
		Opportunity newOpportunity = opportunityrepository.save(opportunity);

		OpportunityResponse response = new OpportunityResponse();
		response.setOpportunity(newOpportunity);
		response.setStatusCode(200);
		response.setStatusMessage("SAVED SUCCESSFULLY");
		return response;
		}
		else
			
			throw new OperationProhibitedException("you don't have authorities to post Opportunity");
	}


	/**
	 * 
	 * This  method is used to update data into Opportunity table.
	 * 
	 * This method consists of business logic which is used to update details of Opportunity table.
	 * 
	 * @param request contains attributes of {@link OpportunityRequest}
	 * 
	 * @param1 id contains id of Opportunity.
	 *
	 * @return the response status message
	 * 
	 */
	@Override
	public OpportunityResponse updateOpportunity(Long id,OpportunityRequest request) {
		

		LOGGER.info("REACHED service");
		Opportunity opty = opportunityrepository.findOne(id);
		
		if(opty == null)
		{
			throw new DataNotFoundException("Opportunity not found");
		}
		Party pty = ptyRepository.findOne(request.getPartyId());
		if (pty == null) {
			throw new DataNotFoundException("Party not found");
		}
		
		Category category = categoryRepository.findByName(request.getCategoryName());
		if(category == null)
		{
		category = new Category();
		category.setName(request.getCategoryName());
		}
		
		OpportunityType optType = opportunityTypeRepository.findByType(request.getOppurtunityName());		
		if(optType == null)
		{		
		optType = new OpportunityType();
		optType.setType(request.getOppurtunityName());
		}
		
		Qualification qual= qualificationRepository.findByName(request.getQualificationName());
		if(qual== null)
		{
			qual = new  Qualification();
			qual.setName(request.getQualificationName());
		}
		opty.setParty(pty);
		opty.setTitle(request.getTitle());
		opty.setLocation(request.getLocation());
		opty.setDesiredSkills(request.getDesiredSkills());
		opty.setType(request.getType());
		opty.setCategory(category);
		opty.setOpportunityType(optType);
		opty.setDescription(request.getDescription());
		opty.setHowToApply(request.getHowToApply());
		opty.setLinkRef(request.getLinkRef());
		opty.setStatus(request.getStatus());
		opty.setRole(request.getRole());
		opty.setDepartment(request.getDepartment());
		opty.setMinWage(request.getMinWage());
		opty.setLiveOrFuture(request.getLiveOrFuture());
		opty.setStartDate(request.getStartDate());
		opty.setEndDate(request.getEndDate());
		opty.setDuration(request.getDuration());
		opty.setQualification(qual);
		opty.setMinAge(request.getMinAge());
		opty.setWageType(request.getWageType());
		opty.setShortDescription(request.getShortDescription());
		
		Opportunity savedOpportunity = opportunityrepository.save(opty);

		OpportunityResponse response = new OpportunityResponse();
		response.setOpportunity(savedOpportunity);
		response.setStatusCode(200);
		response.setStatusMessage("UPDATED SUCCESSFULLY");
		return response;

	}
	
	private Sort orderBy(String id) {
        return new Sort(Sort.Direction.DESC, id);
    }
	/**
	 * 
	 * This  method is used to list out data from Opportunity table.
	 * 
	 * This method consists of business logic which is used to get details of Opportunity table.
	 * 
	 * @param request contains attributes of {@link OppurtunityBeanRequest}
	 * 
	 * @return the response status message
	 * 
	 */
	@Override
	public OpportunityListResponse getOpportunity(OppurtunityBeanRequest request) {

		OpportunityListResponse response = new OpportunityListResponse();
		
		
		OpportunitySpecifications spec = new OpportunitySpecifications(request);
		
		List<Opportunity> lstOpportunity = opportunityrepository.findAll(spec, orderBy("id"));
		
	
		if(lstOpportunity!= null)
		{
		response.setLstOpportunity(lstOpportunity);
		response.setStatusCode(200);
		response.setStatusMessage("RETRIEVED SUCCESSFULLY");
		}
		else
		{
			response.setStatusCode(204);
			response.setStatusMessage("EMPTY LIST");
		}
		
		return response;
		
				
	} 

	}


