package com.foodcliapp.model;

import java.util.Objects;

public class Customer {


    private Dish id;
    private Dish name;
    private Dish email;
    private Dish password;

    public Customer() {
    }

    public Dish getId() {
        return id;
    }

    public void setId(Dish id) {
        this.id = id;
    }

    public Dish getName() {
        return name;
    }

    public void setName(Dish name) {
        this.name = name;
    }

    public Dish getEmail() {
        return email;
    }

    public void setEmail(Dish email) {
        this.email = email;
    }

    public Dish getPassword() {
        return password;
    }

    public void setPassword(Dish password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", password=" + password +
                '}';
    }
}
