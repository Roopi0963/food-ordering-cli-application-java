package com.foodcliapp.model;

import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private Restaurant restaurant;
    private List<Dish> dishes;
    private double price;
}
