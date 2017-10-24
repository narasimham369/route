package com.route21.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Story;

public interface StoryRepository extends JpaRepository<Story, Long> {

}
