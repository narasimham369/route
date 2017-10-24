package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.PartyQualification;

public interface PartyQualificationRepository extends JpaRepository<PartyQualification, Long> {

	@Query(value="SELECT q FROM PartyQualification q WHERE q.party.id=:ptyId")
	public List<PartyQualification> findByPtyId(@Param("ptyId")Long ptyId);

}
