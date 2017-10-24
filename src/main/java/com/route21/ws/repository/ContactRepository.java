package com.route21.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route21.ws.bean.Contact;


public interface ContactRepository extends JpaRepository<Contact,Long> {
	
	public List<Contact> findAllByOrderByIdDesc(); 
}
