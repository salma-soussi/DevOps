package com.poly.plantManagement.service;

import java.util.List;

import com.poly.plantManagement.entities.Bill;

public interface IServiceBill {
	
    void saveBill(Bill bill);
    List<Bill> getAllBills();
    Bill getBill(int id);
    void deleteBill(int id);
}
