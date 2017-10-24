package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.PartyActivity;


/**
 * 
 * It is the interface named as PartyActivityRepository.
 * 
 * It extends the jpa repository.
 * 
 * It has query annotation to get data base values according to our requirement.
 * 
 * It have list object also, to hold the party activity records.
 * 
 * @author admin-pc
 *
 */
public interface PartyActivityRepository extends JpaRepository<PartyActivity, Long>{

	@Query("SELECT pa from PartyActivity pa where pa.party.id=:id")
	public List<PartyActivity> findPartyActivityById(@Param("id") Long id);

	@Query("SELECT pa from PartyActivity pa where pa.activityType.id=:ActId AND pa.party.id=:PtyId")
	public List<PartyActivity> findPtyActivityListByPtyIdAndActId(@Param("PtyId") Long PtyId, @Param("ActId") Long ActId);
	
	@Query("SELECT pa from PartyActivity pa where pa.activityType.id=:ActId AND pa.party.id=:PtyId")
	public PartyActivity findPtyActivityByPtyIdAndActid(@Param("PtyId") Long PtyId, @Param("ActId") Long ActId);
}
