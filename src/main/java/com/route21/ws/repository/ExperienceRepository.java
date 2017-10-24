package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.route21.ws.bean.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Long>{

	@Query("SELECT e from Experience e where e.party.id=:id")
	public List<Experience> findExperienceById(@Param("id") Long id);
}
