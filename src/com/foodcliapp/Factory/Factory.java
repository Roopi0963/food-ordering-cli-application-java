package com.foodcliapp.Factory;

import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.controller.RestaurantController;
import com.foodcliapp.repository.CustomerRepository;
import com.foodcliapp.repository.RestaurantRepository;
import com.foodcliapp.service.CustomerServiceImpl;
import com.foodcliapp.service.RestaurantServiceImpl;

public class Factory {

    public static CustomerController customerController;

    public static CustomerRepository getCustomerRepository(){
        return new CustomerRepository();
    }

    public static CustomerServiceImpl getCustomerService(){
        return new CustomerServiceImpl(getCustomerRepository());

    }

    public static CustomerController getCustomerController(){

        return new CustomerController(getCustomerService());
    }


    public static RestaurantRepository getRestaurantRepository(){
        return new RestaurantRepository();
    }
    public static RestaurantServiceImpl getRestaurantService(){
        return new RestaurantServiceImpl(getRestaurantRepository());
    }

    public static RestaurantController getrestaurantController(){
        return new RestaurantController(getRestaurantService());
    }
}
