package com.foodcliapp.util;

import com.foodcliapp.model.Customer;
import com.foodcliapp.model.Restaurant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVWriter {
    private static final String CUSTOMER_CSV_PATH = "K:\\project\\food-ordering-cli-application-java\\DATA\\customers.csv";
    private static final String CSV_HEADER = "id,name,email,password";

    public void writeCustomersToCsv(List<Customer> customerList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMER_CSV_PATH))) {
            // Write the CSV header
            bw.write(CSV_HEADER);
            bw.newLine();

            // Write each customer's data
            for (Customer customer : customerList) {
                bw.write(String.format("%s,%s,%s,%s",
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPassword()));
                bw.newLine();  // Move to the next line
            }

//            System.out.println("Customer data successfully written to CSV.");

        } catch (IOException e) {
            System.out.println("Error occurred while writing to CSV.");
            e.printStackTrace();
        }
    }


    public void writeRestaurantsToCsv(List<Restaurant> restaurantList){
        String RESTAURANT_CSV_PATH = "K:\\project\\food-ordering-cli-application-java\\DATA\\restaurants.csv";
        String CSV_HEADER = "restaurantId,name,address,Menu";
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(RESTAURANT_CSV_PATH))){
            bw.write(CSV_HEADER);

            bw.newLine();

            for (Restaurant restaurant : restaurantList){
                bw.write(String.format("%s,%s,%s,%s",
                        restaurant.getId(),
                        restaurant.getName(),
                        restaurant.getAddress(),
                        restaurant.getMenu()));
                bw.newLine();
            }

//            System.out.println("Restaurant data successfully written to CSV.");

        } catch (IOException e) {
            System.out.println("Error occurred while writing to CSV.");
            e.printStackTrace();
        }
    }
}
