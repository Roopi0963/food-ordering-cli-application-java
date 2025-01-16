package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;


}
