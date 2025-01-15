package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;
import com.foodcliapp.repository.CustomerRepository;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistException {

        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isEmpty())
            throw new CustomerExistException("Customer is already present"+customer.getId());

        return this.save(customer);
    }


}
