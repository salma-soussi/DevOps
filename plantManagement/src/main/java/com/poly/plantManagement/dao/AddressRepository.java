package com.poly.plantManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poly.plantManagement.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
