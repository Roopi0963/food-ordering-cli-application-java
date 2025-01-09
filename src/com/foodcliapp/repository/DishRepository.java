package com.foodcliapp.repository;

import com.foodcliapp.model.Dish;
import com.foodcliapp.util.CsvReader;

import java.util.List;

public class DishRepository {


    private List<Dish> dishList;

    public DishRepository(){
        CsvReader csvReader = new CsvReader();
        this.dishList=csvReader.readDishesFromCsv();
    }

    public List<Dish> getDishList() {
        return dishList;
    }
}
