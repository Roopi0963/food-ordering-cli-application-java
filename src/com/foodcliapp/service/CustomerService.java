package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer customer) throws CustomerExistException;

    public Customer getCustomerById(String id) throws CustomerNotFoundException;

    public List<Customer> getAllCustomers();

    public Customer update(Customer customer) throws CustomerNotFoundException;

    public void delete(String id) throws CustomerNotFoundException;

    public Customer validateCustomerLogin(String email,String password) throws CustomerNotFoundException;

    public void setCurrentLoggedInCustomer(Customer customer);

    public Customer getCurrentLoggedInCustomer();




}
