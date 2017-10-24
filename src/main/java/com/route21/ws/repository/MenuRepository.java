package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Menu;


public interface MenuRepository extends JpaRepository<Menu,Long> {
	
	public List<Menu> findByTypeOrderBySortAsc(String type);
}