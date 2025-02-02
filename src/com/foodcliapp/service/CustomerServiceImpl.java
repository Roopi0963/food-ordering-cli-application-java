package com.foodcliapp.service;

import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;
import com.foodcliapp.repository.CustomerRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private Customer currentLoggedInCustomer;

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
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer is not found with id " + id);
        return customerById.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.getCustomersList();
    }

    @Override
    public Customer update(Customer customer) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(customer.getId());
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer not found with id "+customer.getId());
        return this.customerRepository.updateCustomer(customer);
    }

    @Override
    public void delete(String id) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerById(id);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Customer not found with id "+id);
        this.customerRepository.deleteCustomer(customerById.get());

    }

    @Override
    public Customer validateCustomerLogin(String email, String password) throws CustomerNotFoundException {
        Optional<Customer> customerById = this.customerRepository.findCustomerByEmail(email,password);
        if(customerById.isEmpty())
            throw new CustomerNotFoundException("Invalid email or password");
        return customerById.get();
    }

    @Override
    public void setCurrentLoggedInCustomer(Customer customer) {
        this.currentLoggedInCustomer = customer;

    }

    @Override
    public Customer getCurrentLoggedInCustomer() {
        return this.currentLoggedInCustomer;

    }
}
