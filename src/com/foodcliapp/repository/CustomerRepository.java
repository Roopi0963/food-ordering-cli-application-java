package com.foodcliapp.repository;

import com.foodcliapp.model.Customer;
import com.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private List<Customer> customersList;


    public CustomerRepository(){
        CsvReader csvReader = new CsvReader();
//        csvReader.readCustomerFromCsv();
        this.customersList=csvReader.readCustomerFromCsv();
    }

    public List<Customer> getCustomersList() {

        return this.customersList;
    }

    public Customer save(Customer customer){
        this.customersList.add(customer);
        return customer;
    }


    public Optional<Customer> findCustomerById(String id){
        return this.customersList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
   public Optional<Customer> findCustomerByEmail(String email){
        return this.customersList.stream().filter(customer -> customer.getEmail().equals(email)).findAny();
    }
}
