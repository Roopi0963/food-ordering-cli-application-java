package com.foodcliapp.ui;

import java.util.Scanner;

public class Menu {
    public Menu() {
    }


    public void displayMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            while(true){
                displayMainMenu("WELCOME TO CUSTOMER SECTION");
                System.out.println();
                System.out.println("Please select the option.");
                System.out.println("-----------------------------");
                System.out.println("1. Customer Section");
                System.out.println("2. Restaurant Section");
                System.out.println("3. Dishes Section");
                System.out.println("4. Order Section");
                System.out.println("5. Exit");
                System.out.println("Please enter your choice 1-5");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> new CustomerMenu().displayMenu();
                }


            }
        } catch (Exception e) {
            System.out.println();
        }



    }

    public void displayMainMenu(String menuHeader){
        printDashLines();
        String spaces = new String(new char[70]).replace('\0',' ');
        System.out.printf("%-70s %-10s %-70s \n", spaces, menuHeader, spaces);
        printDashLines();
    }
    public void printDashLines(){
        String dashLines = new String(new char[150]).replace('\0','-');
        System.out.println(dashLines);
    }

}
