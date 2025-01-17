package com.foodcliapp.ui;

import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.repository.CustomerRepository;
import com.foodcliapp.service.CustomerServiceImpl;

public class Factory {

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());

    }

    public static CustomerController getCustomerController(){
        return new CustomerController(getCustomerService());
    }
}
