package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{

}
