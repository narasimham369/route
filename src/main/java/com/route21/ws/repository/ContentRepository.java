package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Content;


public interface ContentRepository extends JpaRepository<Content,Long> {
	
	List<Content> findByPageUrlOrderBySortAsc(String pageUrl);
	
	List<Content> findAllByOrderByPageNameAsc();
	
}
