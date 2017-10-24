package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.ApplyOpportunity;

public interface ApplyOpportunityRepository extends JpaRepository<ApplyOpportunity, Long>{

	@Query("SELECT a from ApplyOpportunity a where a.opportunity.id=:id")
	List<ApplyOpportunity> findApplyOpportunityByOpportunityId(@Param("id") Long id);
	
	@Query("SELECT a from ApplyOpportunity a where a.party.id=:id")
	List<ApplyOpportunity> findApplyOpportunityByPartyId(@Param("id") Long id);	
	
}
