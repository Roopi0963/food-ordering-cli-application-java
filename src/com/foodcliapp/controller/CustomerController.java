package com.foodcliapp.controller;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;
import com.foodcliapp.service.CustomerServiceImpl;

import java.util.List;

public class CustomerController {
    private CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService){
        this.customerService=customerService;
    }

    public Customer save(Customer customer) throws CustomerExistException {
        return this.customerService.save(customer);
    }

    public Customer validateCustomerLogin(String email,String password) throws CustomerNotFoundException{
        Customer customer = this.customerService.validateCustomerLogin(email,password);
        if(customer != null)
            this.customerService.setCurrentLoggedInCustomer(customer);
        return customer;
    }

    public Customer currentLoggedInCustomer(){
        return this.customerService.getCurrentLoggedInCustomer();
    }

    public Customer getCustomerById(String id) throws CustomerNotFoundException{
        return this.customerService.getCustomerById(id);

    }

    public List<Customer> getCustomersList(){
        return this.customerService.getAllCustomers();
    }

    public Customer updateCustomer(Customer customer) throws  CustomerNotFoundException{
        return this.customerService.update(customer);

    }

    public void deleteCustomer(String id) throws  CustomerNotFoundException{
        this.customerService.delete(id);
    }
}
