package com.route21.ws.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.route21.ws.bean.Opportunity;
import com.route21.ws.bean.Opportunity_;
import com.route21.ws.request.OppurtunityBeanRequest;

public class OpportunitySpecifications implements Specification<Opportunity> {

	private static final Logger LOGGER = LoggerFactory.getLogger(OpportunitySpecifications.class);
	
	private final OppurtunityBeanRequest opportunitySearch;
	
	public OpportunitySpecifications(OppurtunityBeanRequest opportunitySearch) {
		System.out.println("reach specification");
		this.opportunitySearch = opportunitySearch;
	}
	
	
	@Override
	public Predicate toPredicate(Root<Opportunity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		LOGGER.info("toPredicate method called");
		List<Predicate> predicates = new ArrayList();
		
		if(opportunitySearch.getOptid() != 0)
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.id), opportunitySearch.getOptid()));
	    }
	   

	    if (!StringUtils.isEmpty(opportunitySearch.getTitle())) {
	    	
	      predicates.add(cb.like(cb.lower(root.get(Opportunity_.title)),"%"+ opportunitySearch.getTitle().toLowerCase() + "%"));
	    }

	    if (!StringUtils.isEmpty(opportunitySearch.getLocation())) {
	    	LOGGER.info("Location ::"+opportunitySearch.getLocation());
	      predicates.add(cb.like(cb.lower(root.get(Opportunity_.location)), "%"+ opportunitySearch.getLocation().toLowerCase() + "%"));
	    	
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getType())) {
	    	predicates.add(cb.equal(cb.lower(root.get(Opportunity_.type)), opportunitySearch.getType().toLowerCase()));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getRole())){
	    	predicates.add(cb.equal(cb.lower(root.get(Opportunity_.role)),"%"+ opportunitySearch.getRole().toLowerCase() + "%"));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getDepartment()))
	    {
	    	predicates.add(cb.equal(cb.lower(root.get(Opportunity_.department)),"%"+ opportunitySearch.getDepartment().toLowerCase() + "%"));
	    }
	    
	    if(opportunitySearch.getMinWage() != 0.0)
	    {
	    	predicates.add(cb.ge(root.get(Opportunity_.minWage), opportunitySearch.getMinWage()));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getLiveOrFuture()))
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.liveOrFuture), opportunitySearch.getLiveOrFuture()));
	    }
	    
	    if(opportunitySearch.getStartDate() != null)
	    {
	    	 predicates.add(cb.equal(root.get(Opportunity_.startDate), opportunitySearch.getStartDate()));
	    }
	    
	    if(opportunitySearch.getEndDate() != null)
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.endDate), opportunitySearch.getEndDate()));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getDuration()))
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.duration), opportunitySearch.getDuration()));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getMinQualification()))
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.qualification), opportunitySearch.getMinQualification()));
	    }
	    
	    if(opportunitySearch.getMinAge() != 0 )
	    {
	    	predicates.add(cb.ge(root.get(Opportunity_.minAge), opportunitySearch.getMinAge()));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getDesiredSkills()))
	    {
	    	predicates.add(cb.like(cb.lower(root.get(Opportunity_.desiredSkills)),"%"+ opportunitySearch.getDesiredSkills().toLowerCase() + "%"));
	    }
	    
	    if(!StringUtils.isEmpty(opportunitySearch.getStatus()))
	    {
	    	predicates.add(cb.like(cb.lower(root.get(Opportunity_.status)),"%" + opportunitySearch.getStatus().toLowerCase() + "%"));
	    }
	   
	    if(opportunitySearch.getOrgId() != 0)
	    {
	    	predicates.add(cb.equal(root.get(Opportunity_.party), opportunitySearch.getOrgId()));
	    }
	    return andTogether(predicates, cb);
	  }
	
	
	

	  private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[predicates.size()]));
	  }
		
		
		
		

}
