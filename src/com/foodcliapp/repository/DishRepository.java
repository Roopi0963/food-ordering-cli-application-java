package com.foodcliapp.repository;

import com.foodcliapp.model.Dish;
import com.foodcliapp.util.CsvReader;

import java.util.List;
import java.util.Optional;

public class DishRepository {


    private List<Dish> dishList;

    public DishRepository(){
        CsvReader csvReader = new CsvReader();
        this.dishList=csvReader.readDishesFromCsv();
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public Dish save(Dish dish){
        this.dishList.add(dish);
        return dish;
    }

    public Optional<Dish> findDishById(String id){
        return this.dishList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }

    public void deleteDish(Dish dish){
        this.dishList.remove(dish);
    }

    public Dish updateDish(Dish dishToBeUpdated){
        Optional<Dish> updateDish = this.dishList.stream().filter(dish -> dish.getId().equals(dishToBeUpdated))
                .findFirst()
                .map(dish -> {
                    dish.setName(dishToBeUpdated.getName())
                            .setDescription(dishToBeUpdated.getDescription())
                            .setPrice(dishToBeUpdated.getPrice());
                    return dish;
                });
        return updateDish.orElse(null);
    }



}
