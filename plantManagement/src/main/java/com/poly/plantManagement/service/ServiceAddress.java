package com.poly.plantManagement.service;

import org.springframework.stereotype.Service;

import com.poly.plantManagement.dao.AddressRepository;
import com.poly.plantManagement.entities.Address;

@Service
public class ServiceAddress implements IServiceAddress{
	private AddressRepository ar;

	
	public ServiceAddress(AddressRepository ar) {
		super();
		this.ar = ar;
	}

	@Override
	public void saveAddress(Address address) {
		 ar.save(address);
		
	}

	@Override
	public Address getAddress(int id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}

	@Override
	public void deleteAddress(int id) {
		ar.deleteById(id);
		
	}

}
