package com.foodcliapp.service;

import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.model.Restaurant;

public interface RestaurantService {
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException;

}
