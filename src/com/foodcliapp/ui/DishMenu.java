package com.foodcliapp.ui;

import com.foodcliapp.controller.DishController;

import java.util.List;
import java.util.Scanner;

public class DishMenu extends Menu{
    private final DishController dishController;

    public DishMenu(DishController dishController) {
        this.dishController = dishController;
    }

    public void displayMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            displayMenuHeader("WELCOME DISH SECTION");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("1. Add New Dish");
            System.out.println("2. Search Dishes");
            System.out.println("3. Display all Dishes");
            System.out.println("4. Update Customer");
            System.out.println("5. Delete Customer");
            System.out.println("6. Exit");

            System.out.println("Choose option (1-6)");

            int input = scanner.nextInt();
            switch(input){
                case 1 -> newDishForm();

                case 2 -> dishSearchForm();

                case 3 -> displayAllDishes();

                case 4 -> dishUpdateForm();

                case 5 -> dishDeleteForm();

                case 6 -> {
                    System.out.println("Thank You for visiting. See you again....");
                    super.displayMenu();
                }
                default -> {
                    System.out.println("Invalid Input. Please enter the valid input from(1-7)");
                }
            }
        } catch (Exception e) {
            System.out.println("Some internal occurred.Please try again....!");
            displayMenu();
        }
    }

    public void newDishForm(){


    }

    public void dishSearchForm(){

    }

    public void displayAllDishes(){



    }

    public void dishUpdateForm(){

    }

    public void dishDeleteForm(){

    }
}
