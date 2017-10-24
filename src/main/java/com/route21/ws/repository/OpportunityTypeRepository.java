package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.OpportunityType;

public interface OpportunityTypeRepository extends JpaRepository<OpportunityType, Long>{

	OpportunityType findByType(String oppurtunityName);



}
