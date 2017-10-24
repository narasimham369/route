package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	
	

}
