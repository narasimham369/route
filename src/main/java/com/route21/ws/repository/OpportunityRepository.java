package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.Opportunity;

/**
 * 
 * It is the interface named as opportunity repository.
 * 
 * It extends the jpa repository.
 * 
 * It has query annotation to get data base values according to our requirement.
 * 
 * It have list object also, to get the parameters.
 * 
 * @author admin-pc
 *
 */


public interface OpportunityRepository extends JpaRepository<Opportunity, Long>,JpaSpecificationExecutor<Opportunity>{

	@Query(value=" SELECT * FROM OPPORTUNITY AS O LEFT JOIN PARTY AS P ON O.PTY_ID = P.ID WHERE CASE WHEN IFNULL(O.TITLE,'')!=':' THEN O.TITLE LIKE '%%' END AND"
			+ " CASE WHEN IFNULL(O.LOCATION,'')!='' THEN O.LOCATION='Chennai' END AND CASE WHEN IFNULL(O.CATEGORY,'')!='' THEN O.CATEGORY='IT' END"
			+ " AND CASE WHEN IFNULL(P.NAME,'')!='' THEN  P.NAME LIKE '%VISWANATH%' END",nativeQuery=true)
	public List<Opportunity> findOpportunity(@Param("category") String category,@Param("type") String type,@Param("location") String location,@Param("organisation") String organisation);

}

		