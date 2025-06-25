package com.foodcliapp.controller;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.repository.DishRepository;
import com.foodcliapp.service.DishServiceImpl;

import java.awt.*;
import java.util.List;

public class DishController {
    private final DishServiceImpl dishServiceImp;


    public DishController(DishRepository dishRepository) {
        this.dishServiceImp = new DishServiceImpl(dishRepository);
    }

    public Dish save(Dish dish) throws DishExistException{
        return this.dishServiceImp.save(dish);
    }

    public List<Dish> getDisesList(){
        return this.dishServiceImp.dishList();
    }

    public Dish getDishById(String id) throws DishNotFoundException {
        return this.dishServiceImp.findDishById(id);
    }

    public Dish updateDish(Dish dish) throws DishNotFoundException {
        return this.dishServiceImp.updateDish(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException {
        this.dishServiceImp.deleteDish(id);
    }


}
