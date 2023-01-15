package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
