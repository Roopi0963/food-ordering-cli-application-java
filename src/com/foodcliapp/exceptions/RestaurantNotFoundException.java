package com.foodcliapp.exceptions;

public class RestaurantNotFoundException extends Exception{
    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
