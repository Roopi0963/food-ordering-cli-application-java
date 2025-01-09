package com.foodcliapp.repository;

import com.foodcliapp.model.Restaurant;
import com.foodcliapp.util.CsvReader;

import java.util.List;

public class RestaurantRepository {


    private List<Restaurant> restaurantList;

    public RestaurantRepository(){
        CsvReader csvReader = new CsvReader();
        this.restaurantList=csvReader.readRestaurantFromCsv();
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }
}
