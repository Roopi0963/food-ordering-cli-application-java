package com.foodcliapp.ui;

import com.foodcliapp.controller.CustomerController;
import com.foodcliapp.exceptions.CustomerExistException;
import com.foodcliapp.exceptions.CustomerNotFoundException;
import com.foodcliapp.model.Customer;

import java.util.List;
import java.util.Scanner;

import static com.foodcliapp.Factory.Factory.getCustomerController;

public class CustomerMenu extends Menu{
    private final CustomerController customerController;
    public CustomerMenu(){
        this.customerController = getCustomerController();
    }
    @Override
    public  void displayMenu(){
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
                case 3 -> customerSearchForm();
                case 4 -> displayAllCustomers();
                case 5 -> customerUpdateForm();
                case 6 -> customerDeleteForm();
                case 7 -> {
                    System.out.println("Thank You.See you again....");
                    super.displayMenu();
                }
                default -> System.out.println("Invalid input. Please enter valid input from(1-7) ");

            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred.Please try again.....! ");
            displayMenu();
        }

    }



    public void customerRegisterForm(){
        try{
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
            customer.setId(id)
                    .setName(name)
                    .setEmail(email)
                    .setPassword(password);
            Customer savedCustomer = customerController.save(customer);
            System.out.println("Customer Registration successful.");
            

        }catch (CustomerExistException e){
            System.out.println(e.getMessage());
            System.out.println("Customer already exist, Please login using main menu");
            customerRegisterForm();
        }
    }

    public void customerLoginForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details : \n");
            System.out.println("Enter E-Mail : ");
            String email = scanner.nextLine();
            System.out.println("Enter password : ");
            String password = scanner.nextLine();
            Customer existingCustomer = customerController.validateCustomerLogin(email,password);
            System.out.println("Login Successful : ");
            System.out.println("Welcome Mr. "+existingCustomer.getName());
        }catch (CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }


    }

    public void customerSearchForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search the customer : \n");
            System.out.println("Enter Id : ");
            String id = scanner.nextLine();
            Customer customer = customerController.getCustomerById(id);
//            displayCustomerDetails(customer);
        }catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    public void displayAllCustomers(){
        List<Customer> customersList =  this.customerController.getCustomersList();
        String dashesLine = new String(new char[150]).replace('\0', '-');
        displayMenuHeader("Customers");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "E-mail", "Password");
        System.out.println(dashesLine);
        customersList.forEach(customer -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", customer.getId(), customer.getName(), customer.getEmail(), "*".repeat(customer.getPassword().length()));
        });
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
            Customer updateCustomer = customerController.updateCustomer(customer);
            System.out.println("Customer Updated Successfully.");
//            displayCustomerDetails(updateCustomer);
        } catch (Exception e) {
            System.out.println("Please");
        }

    }
    public void customerDeleteForm(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete Customer : \n");
            System.out.println("Enter Id : ");
            String id = scanner.nextLine();
            customerController.deleteCustomer(id);
            System.out.println("Customer deleted Successfully.");
        }catch(CustomerNotFoundException e){
            System.out.println(e.getMessage());
            displayMenu();
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


