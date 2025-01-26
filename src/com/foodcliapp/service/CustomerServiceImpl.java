package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;
import com.foodcliapp.repository.CustomerRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws CustomerExistException {

        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isPresent())
            throw new CustomerExistException("Customer is already present : "+customer.getId());

        return this.customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(!customerById.isPresent())
            throw new CustomerNotFoundException("Customer is not found" + id);
        return customerById.get();
    }


}
