package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Qualification;

public interface QualificationRepository extends JpaRepository<Qualification, Long> {

	public Qualification findByName(String qualificationName);
}
