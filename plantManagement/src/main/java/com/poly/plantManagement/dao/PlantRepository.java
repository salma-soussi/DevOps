package com.poly.plantManagement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer> {

	 
     List<Plant> findAllByCategories_id( Integer id);	
}
