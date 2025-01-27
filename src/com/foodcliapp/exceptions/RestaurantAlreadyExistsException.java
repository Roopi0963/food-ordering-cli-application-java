package com.foodcliapp.exceptions;

public class RestaurantAlreadyExistsException extends Exception{
    public RestaurantAlreadyExistsException(String message) {
        super(message);
    }
}
