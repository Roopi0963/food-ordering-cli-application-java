package com.foodcliapp.repository;

import com.foodcliapp.model.Customer;
import com.foodcliapp.util.CSVWriter;
import com.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    List<Customer> customersList;

    private final CSVWriter csvWriter = new CSVWriter();

    public CustomerRepository(){
        CsvReader csvReader = new CsvReader();
        this.customersList=csvReader.readCustomerFromCsv();
    }

    public List<Customer> getCustomersList() {
        return this.customersList;
    }

    public Customer save(Customer customer){
        this.customersList.add(customer);
        csvWriter.writeCustomersToCsv(customersList);
        return customer;
    }


    public Optional<Customer> findCustomerById(String id){
        return this.customersList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }
   public Optional<Customer> findCustomerByEmail(String email){
        return this.customersList.stream().filter(customer -> customer.getEmail().equals(email)).findAny();
    }

    public Customer updateCustomer(Customer customerToBeUpdated){
        Optional<Customer> updateCustomer = this.customersList.stream().filter(customer -> customer.getId().equals(customerToBeUpdated))
                .findFirst()
                .map(customer -> {
                    customer.setName(customerToBeUpdated.getName())
                            .setEmail(customerToBeUpdated.getEmail())
                            .setPassword(customerToBeUpdated.getPassword());
                    return customer;

                });
        csvWriter.writeCustomersToCsv(customersList);
        return updateCustomer.orElse(null);

    }

    public void deleteCustomer(Customer customer){
        this.customersList.remove(customer);
        csvWriter.writeCustomersToCsv(customersList);
    }

    public Optional<Customer> findCustomerByEmailAndPassword(String email, String password){
        return this.customersList.stream().filter(customer -> customer.getEmail().equalsIgnoreCase(email) && customer.getPassword().equals(password)).findFirst();
    }


}
