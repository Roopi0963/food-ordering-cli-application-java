package com.foodcliapp.controller;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.repository.DishRepository;

public class DishController {
    private DishRepository dishRepository;

    public DishController(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish save(Dish dish) throws DishExistException{
        return this.dishRepository.save(dish);
    }
}
