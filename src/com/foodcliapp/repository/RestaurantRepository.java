package com.foodcliapp.repository;

import com.foodcliapp.model.Restaurant;
import com.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {


    private List<Restaurant> restaurantList;


    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList=csvReader.readRestaurantFromCsv();
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }


    public Restaurant save(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        return restaurant;
    }

    public Optional<Restaurant> findRestaurantById(String id){
        return this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(id)).findFirst();
    }

    public Restaurant updateRestaurant(Restaurant restaurantToBeUpdated){
        Optional<Restaurant> updateRestaurant = this.restaurantList.stream().filter(restaurant -> restaurant.getId().equals(restaurantToBeUpdated))
                .findFirst()
                .map(restaurant -> {
                    restaurant.setId(restaurantToBeUpdated.getId())
                            .setName(restaurantToBeUpdated.getName())
                            .setAddress(restaurantToBeUpdated.getAddress())
                            .setMenu(restaurantToBeUpdated.getMenu());
                    return restaurantToBeUpdated;
                });
        return updateRestaurant.orElse(null);
    }
    public void deleteRestaurant(Restaurant restaurant){
        this.restaurantList.remove(restaurant);

    }



}
