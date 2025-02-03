package com.foodcliapp.service;

import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.exceptions.RestaurantNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.model.Restaurant;

import java.util.List;

public interface RestaurantService {
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException;

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException;

    public List<Restaurant> getAllRestaurants();

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException;

    public void deleteRestaurant(String id) throws RestaurantNotFoundException;

    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException;


}
