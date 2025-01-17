package com.foodcliapp.ui;

import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;


import java.util.Scanner;

public class Menu {

    public void displayMainMenu(){

        Scanner scanner =new Scanner(System.in);
        while (true){

            System.out.println("---------------------------------------------------------------------------");
            System.out.println("                    Welcome Food Ordering Cli App                          ");
            System.out.println("---------------------------------------------------------------------------");

            System.out.println();
            System.out.println("Please select the option");
            System.out.println("1.Registration(New customer)");
            System.out.println("2.Login(Existing customer)");
            System.out.println("3.View Restaurants");
            System.out.println("4.View Menu");
            System.out.println("5.Place Order");
            System.out.println("6.View Orders");
            System.out.println("7.Exit");

            System.out.print("Enter your choice(1-7) : ");

            int input= scanner.nextInt();
            switch (input){
                case 1:
//                    displayRegisterMenu();
                    break;
                case 7:
                    System.out.println("Thank you..............! ");
                    System.exit(0);
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }


}
