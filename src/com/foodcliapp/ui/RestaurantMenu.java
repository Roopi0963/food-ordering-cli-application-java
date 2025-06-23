package com.foodcliapp.ui;

import com.foodcliapp.Factory.Factory;
import com.foodcliapp.controller.RestaurantController;
import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.RestaurantAlreadyExistsException;
import com.foodcliapp.exceptions.RestaurantNotFoundException;
import com.foodcliapp.model.Restaurant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantMenu extends Menu{
    private final RestaurantController restaurantController;

    public RestaurantMenu() {
        this.restaurantController = Factory.getrestaurantController();
    }

    public void displayRestaurantMenu(){
       try{
           Scanner scanner = new Scanner(System.in);
           displayMenuHeader("WELCOME RESTAURANT SECTION");
           System.out.println();
           System.out.println("Please select the option.");
           System.out.println("-------------------------");
           System.out.println("1. Register (New Restaurant)");
           System.out.println("2. Display ALl Restaurants");
           System.out.println("3. Search Restaurant");
           System.out.println("4. Update Restaurant");
           System.out.println("5. Delete Restaurant");
           System.out.println("6. Exit");

           System.out.println("Please enter your choice (1-6) ");

           int input = scanner.nextInt();
           switch(input){

               case 1 -> restaurantRegisterForm();
               case 2 -> displayRestaurants();
               case 3 -> searchRestaurantForm();
               case 4 -> updateRestaurantForm();
               case 5 -> deleteRestaurantForm();
               case 6 -> {
                   System.out.println("Thank You .See you again.......!");
                   super.displayMenu();
               }
               default -> System.out.println("Some internal error occurred.Please try again.");
           }

       } catch (Exception e) {
           System.out.println("Some internal error occurred. Please try again..!");
           displayRestaurantMenu();
       }

    }

    public void restaurantRegisterForm(){
       try{
           Scanner scanner = new Scanner(System.in);
           System.out.println("Please Register using following details ");
           System.out.println("Enter id : ");
           String id = scanner.nextLine();
           System.out.println("Enter Name : ");
           String name = scanner.nextLine();
           System.out.println("Enter Address : ");
           String address = scanner.nextLine();
           System.out.println("Enter Dish Menu :");
           String menu = scanner.nextLine();
           Restaurant restaurant = new Restaurant();
           restaurant.setId(id)
                   .setName(name)
                   .setAddress(address)
                   .setMenu(Arrays.asList(menu.split(":")));
           Restaurant savedRestaurant = restaurantController.save(restaurant);
           System.out.println("Restaurant Saved Successfully.");
           displayRestaurantDetails(savedRestaurant);
       }catch (RestaurantAlreadyExistsException e){
           System.out.println(e.getMessage());
           System.out.println("Restaurant already exist.Please login using main menu.");

       } catch (Exception e) {
           System.out.println("Some internal error occurred.");
           displayRestaurantMenu();
       }


    }

    public void displayRestaurants(){
        List<Restaurant> restaurantList = this.restaurantController.getAllRestaurants();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        System.out.println(dashesLine);
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n",restaurant.getId(),restaurant.getName(),restaurant.getAddress(),restaurant.getMenu());
        });

    }

    public void searchRestaurantForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details.");
            System.out.println("Enter Id : ");
            String id = scanner.nextLine();
            Restaurant restaurant = restaurantController.getRestaurantById(id);
            displayRestaurantDetails(restaurant);


        } catch (RestaurantNotFoundException e) {
            System.out.println(e.getMessage());
            displayRestaurantMenu();
        }

    }

    public void updateRestaurantForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter following details to update the Restaurant");
            System.out.println("Enter Id : ");
            String id = scanner.nextLine();
            System.out.println("Enter Name : ");
            String name = scanner.nextLine();
            System.out.println("Enter Address : ");
            String address = scanner.nextLine();
            System.out.println("Enter Dish Menu :");
            String menu = scanner.nextLine();
            Restaurant restaurant = new Restaurant();
            restaurant.setId(id)
                    .setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurant updatedRestaurant = restaurantController.updateRestaurant(restaurant);
            System.out.println("Restaurant Updated Successfully.");
            displayRestaurantDetails(updatedRestaurant);
        }
        catch (RestaurantNotFoundException e){
            System.out.println(e.getMessage());

        }
        catch (Exception e){
            System.out.println("Some internal occurred. Please try again.......!");
            displayMenu();
        }

    }

    public void deleteRestaurantForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter following details : ");
            System.out.println("Enter Id : ");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant deleted Successfully.");
            restaurantController.deleteRestaurant(id);

        }
        catch (RestaurantNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();

        }

    }

    public void displayRestaurantDetails(Restaurant restaurant){
        displayMenuHeader("Restaurant Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        printDashLines();
        System.out.printf("%-10s %-30s %-80s %-30s\n",restaurant.getId(),restaurant.getName(),restaurant.getAddress(),restaurant.getAddress());

    }
}
