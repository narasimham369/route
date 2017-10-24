package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.route21.ws.bean.Party;

public interface PartyRepository extends JpaRepository<Party, Long>{

	@Query(value="SELECT pty FROM Party pty WHERE pty.partyType.id in (1,3)")
	public List<Party> getNameListofEmployeerandInstitute();
	
	@Query(value="SELECT partyType FROM Party pty WHERE pty.partyType=:id")
	public Party getPartyType();

}
