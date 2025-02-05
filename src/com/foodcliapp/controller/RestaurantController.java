package com.foodcliapp.controller;

import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.exceptions.RestaurantNotFoundException;
import com.foodcliapp.model.Restaurant;
import com.foodcliapp.service.RestaurantServiceImpl;

import java.util.List;

public class RestaurantController {
    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException{
        return this.restaurantService.save(restaurant);
    }

    public List<Restaurant> getAllRestaurants(){
        return this.restaurantService.getAllRestaurants();
    }

    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        return this.restaurantService.getRestaurantById(id);

    }

    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException{
        return this.restaurantService.updateRestaurant(restaurant);
    }

    public void deleteRestaurant(String id) throws RestaurantNotFoundException{
        this.restaurantService.deleteRestaurant(id);

    }

}
