package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	public Category findByName(String categoryName);

}
