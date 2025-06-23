package com.foodcliapp.controller;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.repository.DishRepository;
import com.foodcliapp.service.DishServiceImpl;

public class DishController {
    private final DishServiceImpl dishServiceImp;


    public DishController(DishRepository dishRepository) {
        this.dishServiceImp = new DishServiceImpl(dishRepository);
    }

    public Dish save(Dish dish) throws DishExistException{
        return this.dishServiceImp.save(dish);
    }

    public Dish updateDish(Dish dish) throws DishNotFoundException {
        return this.dishServiceImp.updateDish(dish);
    }

    public void deleteDish(String id) throws DishNotFoundException {
        this.dishServiceImp.deleteDish(id);
    }


}
