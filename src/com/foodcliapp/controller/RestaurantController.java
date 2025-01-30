package com.foodcliapp.controller;

import com.foodcliapp.service.RestaurantServiceImpl;

public class RestaurantController {
    private RestaurantServiceImpl restaurantService;

    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }
}
