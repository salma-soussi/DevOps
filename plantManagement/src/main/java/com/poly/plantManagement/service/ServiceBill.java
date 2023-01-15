package com.poly.plantManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.poly.plantManagement.dao.BillRepository;
import com.poly.plantManagement.entities.Bill;

@Service
public class ServiceBill implements IServiceBill{

	private BillRepository br;
	
	public ServiceBill(BillRepository br) {
		super();
		this.br = br;
	}

	@Override
	public void saveBill(Bill bill) {
		br.save(bill);
	}

	@Override
	public List<Bill> getAllBills() {
		return br.findAll();
	}

	@Override
	public Bill getBill(int id) {
		return br.findById(id).get();
	}

	@Override
	public void deleteBill(int id) {
		br.deleteById(id);
	}

}
