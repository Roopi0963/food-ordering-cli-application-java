package com.foodcliapp.controller;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;
import com.foodcliapp.service.CustomerServiceImpl;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }

    public Customer save(Customer customer) throws CustomerExistException {
        return this.customerService.save(customer);
    }
}
