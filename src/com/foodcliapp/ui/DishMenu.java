package com.foodcliapp.ui;

import com.foodcliapp.controller.DishController;
import com.foodcliapp.exceptions.DishExistException;
import com.foodcliapp.exceptions.DishNotFoundException;
import com.foodcliapp.model.Dish;

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
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
            dish.setId(id)
                    .setName(name)
                    .setDescription(description)
                    .setPrice(price);

            Dish savedDish = this.dishController.save(dish);
            displayDish(savedDish);
        } catch (DishExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            newDishForm();
        }


    }

    public void dishSearchForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Customer\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Dish dish = dishController.getDishById(id);
            displayDish(dish);
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }

    }

    public void displayAllDishes(){
        List<Dish> dishesList = this.dishController.getDisesList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Dish Items");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        System.out.println(dashesLine);
        dishesList.forEach(dish -> {
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        });



    }

    public void dishUpdateForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Dish Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Description");
            String description = scanner.nextLine();
            System.out.println("Enter Price");
            double price = scanner.nextDouble();
            Dish dish = new Dish();
            dish.setId(id)
                    .setName(name)
                    .setDescription(description)
                    .setPrice(price);

            Dish updatedDish = dishController.updateDish(dish);
            System.out.println("Dish Updated Successfully");
            displayDish(updatedDish);

        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            dishUpdateForm();
        }

    }

    public void dishDeleteForm(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Dish\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            dishController.deleteDish(id);
            System.out.println("Dish Deleted Successfully");
        } catch (DishNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }


    }
    public void displayDish(Dish dish) {
        displayMenuHeader("Dish Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLines();
        System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));

    }



}
