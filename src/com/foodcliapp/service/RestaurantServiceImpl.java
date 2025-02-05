package com.foodcliapp.service;

import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.exceptions.RestaurantNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.model.Restaurant;
import com.foodcliapp.repository.DishRepository;
import com.foodcliapp.repository.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private DishRepository dishRepository;



    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public Restaurant save(Restaurant restaurant) throws RestaurantAlreadyExistsException {

        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if(restaurantById.isPresent())
            throw new RestaurantAlreadyExistsException("Restaurant is already exists : "+restaurant.getId());
        return this.restaurantRepository.save(restaurant);

    }

    @Override
    public Restaurant getRestaurantById(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if (restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant is not found with id : "+id);
        return restaurantById.get();
    }

    @Override
    public List<Restaurant> getAllRestaurants() {

        return this.restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(restaurant.getId());
        if (restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with id : " +restaurant.getId());
        return this.restaurantRepository.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(String id) throws RestaurantNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if (restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with id : "+id);
        this.restaurantRepository.deleteRestaurant(restaurantById.get());

    }

    @Override
    public List<Dish> getDishItems(String id) throws RestaurantNotFoundException, DishNotFoundException {
        Optional<Restaurant> restaurantById = this.restaurantRepository.findRestaurantById(id);
        if (restaurantById.isEmpty())
            throw new RestaurantNotFoundException("Restaurant not found with id " + id);
        List<Dish> dishList = new ArrayList<>();
        Restaurant restaurant = restaurantById.get();
        List<String> dishIds = restaurant.getMenu();
//        for (String dishId : dishIds){
//            Dish dish = dishRepository;
//            dishList.add(dish);
//        }

        return dishList;
            
    }


}
