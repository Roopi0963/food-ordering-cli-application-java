package com.foodcliapp.controller;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.service.DishServiceImpl;

import java.util.List;

public class DishController {
    private final DishServiceImpl dishService;


    public DishController(DishServiceImpl dishService) {

        this.dishService = dishService;
    }

    public Dish save(Dish dish) throws DishExistException{
        return this.dishService.save(dish);
    }

    public List<Dish> getDisesList(){
        return this.dishService.dishList();
    }

    public Dish getDishById(String id) throws DishNotFoundException {
        return this.dishService.findDishById(id);
    }

    public Dish updateDish(Dish dish) throws DishNotFoundException {
        return this.dishService.updateDish(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException {
        this.dishService.deleteDish(id);
    }


}
