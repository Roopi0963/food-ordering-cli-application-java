package com.foodcliapp.repository;

import com.foodcliapp.model.Customer;
import com.foodcliapp.util.CsvReader;

import java.util.List;

public class CustomerRepository {
    private List<Customer> customersList;


    public CustomerRepository(){
        CsvReader csvReader = new CsvReader();
//        csvReader.readCustomerFromCsv();
        this.customersList=csvReader.readCustomerFromCsv();
    }

    public List<Customer> getCustomersList() {

        return customersList;
    }
}
