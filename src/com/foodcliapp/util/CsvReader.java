package com.foodcliapp.util;

import com.foodcliapp.model.Customer;
import com.foodcliapp.model.Dish;
import com.foodcliapp.model.Restaurant;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    public List<Dish> readDishesFromCsv(){
        String DISHES_CSV_PATH="K:\\\\project\\\\food-ordering-cli-application-java\\\\DATA\\\\dishes.csv";
        String line;
        List<Dish> dishesList=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(DISHES_CSV_PATH))){
            String cvsSplitBy=",";

            br.readLine();
            while((line=br.readLine())!=null){
                String[] data=line.split(cvsSplitBy);

                Dish dish = new Dish();
                dish.setId(data[0]);
                dish.setName(data[1]);
                dish.setDescription(data[2]);
                dish.setPrice(Double.parseDouble(data[3]));

                dishesList.add(dish);
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
            System.out.println("File not found");
        }
        return dishesList;
    }

    public List<Customer> readCustomerFromCsv(){
        String CUSTOMER_CSV_PATH = "K:\\\\project\\\\food-ordering-cli-application-java\\\\DATA\\\\customers.csv";
        String line;
        List<Customer> customerList=new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_CSV_PATH))){
            String csvSplitBy = ",";
            br.readLine();
            while((line=br.readLine()) != null){
                String[] data = line.split(csvSplitBy);
                Customer customer=new Customer();
                customer.setId(data[0]);
                customer.setName(data[1]);
                customer.setEmail(data[2]);
                customer.setPassword(data[3]);

                customerList.add(customer);
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
            System.out.println("File not found");
        }
        return customerList;
    }


    public List<Restaurant> readRestaurantFromCsv(){
        String RESTAURANT_CSV_PATH = "K:\\\\project\\\\food-ordering-cli-application-java\\\\DATA\\\\restaurants.csv";
        String line;
        List<Restaurant> restaurantList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(RESTAURANT_CSV_PATH))){
            String csvSplitBy=",";

            br.readLine();
            while((line = br.readLine()) != null){
                String[] data =line.split(csvSplitBy);
                Restaurant restaurant = new Restaurant();
                restaurant.setId(data[0]);
                restaurant.setName(data[1]);
                restaurant.setAddress(data[2]);
                restaurant.setMenu(data[3]);
                restaurantList.add(restaurant);
            }

        }catch (IOException e){
            e.printStackTrace();
            System.exit(0);
            System.out.println("File not found");
        }

        return restaurantList;

    }









}
