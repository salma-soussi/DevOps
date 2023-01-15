package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Photos;

public interface PhotosRepository extends JpaRepository<Photos, Integer>{
	Photos findByPlant_id(Integer id);
}
