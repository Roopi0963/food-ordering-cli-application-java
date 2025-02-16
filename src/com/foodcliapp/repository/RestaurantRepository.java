package com.foodcliapp.repository;

import com.foodcliapp.model.Restaurant;
import com.foodcliapp.util.CSVWriter;
import com.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class RestaurantRepository {


    private List<Restaurant> restaurantList;

    private final CSVWriter csvWriter = new CSVWriter();

    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList=csvReader.readRestaurantFromCsv();
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }


    public Restaurant save(Restaurant restaurant){
        this.restaurantList.add(restaurant);
        csvWriter.writeRestaurantsToCsv(restaurantList);
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
        csvWriter.writeRestaurantsToCsv(restaurantList);
        return updateRestaurant.orElse(null);
    }
    public void deleteRestaurant(Restaurant restaurant){
        this.restaurantList.remove(restaurant);
        csvWriter.writeRestaurantsToCsv(restaurantList);
    }



}
