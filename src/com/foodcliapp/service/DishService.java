package com.foodcliapp.service;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;

import java.util.List;

public interface DishService {
    public Dish save(Dish dish) throws DishExistException;

    public List<Dish> dishList();

    public Dish updateDish(Dish dish) throws DishNotFoundException;

    public void deleteDish(String id) throws DishNotFoundException;

    public Dish findDishById(String id) throws DishNotFoundException;
}
