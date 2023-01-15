package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Visitor;

public interface VisitorRepository extends JpaRepository<Visitor, Integer>{
	Visitor findByEmailAndPassword(String email, String password);
}
