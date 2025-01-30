package com.foodcliapp.service;

import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.model.Restaurant;
import com.foodcliapp.repository.RestaurantRepository;

import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

    private RestaurantRepository restaurantRepository;


    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException {

        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isPresent())
            throw new RestaurantAlreadyExistsException("Restaurant is already exists : "+restaurant.getId());
        return this.restaurantRepository.save(restaurant);

    }
}
