package com.foodcliapp.util;

import com.foodcliapp.model.Customer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {
//    public List<Customer> writeCustomerToCsv(){
//        String CUSTOMER_CSV_PATH = "K:\\project\\food-ordering-cli-application-java\\DATA\\customers.csv";
//        List<Customer> customerList = new ArrayList<>();
//        try(BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMER_CSV_PATH))){
//            for (Customer customer : customerList){
//                bw.write(String.format("%s,%s,%s,%s\n",
//                        customer.getId(),
//                        customer.getName(),
//                        customer.getEmail(),
//                        customer.getPassword()));
//                customerList.add(customer);
//
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error occurred ");
//            System.out.println(e.getMessage());
//        }
//        return customerList;
//    }
}
/*
try (
BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMER_CSV_PATH))) {
        bw.write("ID,Name,Email,Password");
            bw.newLine();

// Write each customer
            for (Customer customer : customers) {
        bw.write(customer.getId() + "," +
        customer.getName() + "," +
        customer.getEmail() + "," +
        customer.getPassword());
        bw.newLine();
            }
                    } catch (IOException e) {
        System.out.println(e.getMessage());
        }
*/