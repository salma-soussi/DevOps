package com.poly.plantManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	List<Comment> findAllByPlant_id(Integer id);
}
