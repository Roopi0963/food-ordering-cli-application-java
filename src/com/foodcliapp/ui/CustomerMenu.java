package com.foodcliapp.ui;

import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.model.Customer;

import java.util.Scanner;

public class CustomerMenu {
    public static void displayRegisterMenu(){
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
                displayRegisterMenu();
            }

        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
            System.out.println("Customer already exist, Please login using main menu");
            Menu.displayMainMenu();


        }
    }
}
