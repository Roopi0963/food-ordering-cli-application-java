package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;
    public Customer getCustomerById(String id) throws CustomerNotFoundException;
    


}
