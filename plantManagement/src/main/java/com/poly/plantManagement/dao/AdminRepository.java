package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
