package com.foodcliapp.service;

import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;
import com.foodcliapp.repository.DishRepository;

import java.util.List;
import java.util.Optional;

public class DishServiceImpl implements DishService{

    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public Dish save(Dish dish) throws DishExistException {
        Optional<Dish>  dishById = this.dishRepository.findDishById(dish.getId());
        if (dishById.isPresent())
            throw new DishExistException("Dish with id is already exist"+dish.getId());
        return this.dishRepository.save(dish);
    }

    @Override
    public List<Dish> dishList() {
        return this.dishRepository.getDishList();
    }

    @Override
    public Dish updateDish(Dish dish) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
        if (dishById.isEmpty())
            throw new DishNotFoundException("Dish not found with id: "+dish.getId());

        return this.dishRepository.updateDish(dish);
    }

    @Override
    public void deleteDish(String id) throws DishNotFoundException {
        Optional<Dish> dishById = this.dishRepository.findDishById(id);
        if (dishById.isEmpty())
            throw new DishNotFoundException("Dish not fount with id : "+id);
        this.dishRepository.deleteDish(dishById.get());

    }

    @Override
    public Dish findDishById(String id) throws DishNotFoundException {
        Optional<Dish> findDishById = this.dishRepository.findDishById(id);
        if (findDishById.isEmpty())
            throw new DishNotFoundException("Dish is not found with id : "+id);

        return findDishById.get();
    }


}
