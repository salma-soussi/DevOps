package com.poly.plantManagement.service;

import com.poly.plantManagement.entities.Address;

public interface IServiceAddress {
    void saveAddress(Address address);
    Address getAddress(int id);
    void deleteAddress(int id);
}
