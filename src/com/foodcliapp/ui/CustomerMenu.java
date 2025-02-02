package com.foodcliapp.ui;

import com.foodcliapp.Factory.Factory;
import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;

import java.util.Scanner;

public class CustomerMenu {
    public void displayCustomerMenu(){
        try{
            Scanner scanner = new Scanner(System.in);
            displayMenuHeader("WELCOME CUSTOMER SECTION");
            System.out.println();
            System.out.println("Please select the option !");
            System.out.println("1. Register (New Customer)");
            System.out.println("2. Login (Existing Customer)");
            System.out.println("3. Search Customer");
            System.out.println("4. Display all Customers");
            System.out.println("5. Update Customer");
            System.out.println("6. Delete Customer");
            System.out.println("7. Exit");
            int input= scanner.nextInt();
            switch(input){
                case 1 -> customerRegisterForm();
                case 2 -> customerLoginForm();
//                case 3 -> customerSearchForm();
//                case 4 -> displayAllCustomers();
                case 5 -> customerUpdateForm();
//                case 6 -> customerDeleteForm();
                case 7 -> {
                    System.out.println("Thank You.See you again....");
                    displayCustomerMenu();
                }
                default -> System.out.println("Invalid input. Please enter valid input from(1-7) ");

            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred.Please try again.....! ");
            displayCustomerMenu();
        }

    }



    public static void customerRegisterForm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please register using following details");
        System.out.println("Please enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println("Enter mail");
        String email = scanner.nextLine();
        System.out.println("enter password");
        String password = scanner.nextLine();

        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);

        CustomerController customerController = Factory.getCustomerController();

        try{
            Customer savedCustomer = customerController.save(customer);
            if(savedCustomer != null){
                System.out.println("Customer registration is successful ");
                System.out.println("Details : ");
                System.out.println("Id : "+ customer.getId());
                System.out.println("Name : "+customer.getName());
                System.out.println("Email : "+customer.getEmail());
                System.out.println("Password : "+customer.getPassword());


            }
            else{
                System.out.println("Some internal error occurred, Please try again ");
                customerRegisterForm();
            }

        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
            System.out.println("Customer already exist, Please login using main menu");
//            Menu.displayMainMenu();


        }
    }
    public void customerLoginForm(){

    }

    public void customerUpdateForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please update entering the following details\n");
            System.out.println("Enter Your Id : ");
            String id = scanner.nextLine();
            System.out.println("Enter Name : ");
            String name = scanner.nextLine();
            System.out.println("Enter E-Mail : ");
            String email = scanner.nextLine();
            System.out.println("Enter Password : ");
            String password = scanner.nextLine();
            Customer customer = new Customer();
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);
            Customer updateCustomer = Factory.customerController.updateCustomer(customer);
            System.out.println("Customer Updated Successfully.");
//            displaypalyCustomerDetails(updateCustomer);
        } catch (Exception e) {
            System.out.println("Please");
        }

    }


    public void displayMenuHeader(String menuHeader){
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


