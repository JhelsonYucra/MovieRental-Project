package com.jhelson.movierental;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String customerName;
    private String customerID;
    private List<String> rentedMovies = new ArrayList<>();

    public Cliente(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerID() { return customerID; }
    public void setCustomerID(String customerID) { this.customerID = customerID; }
    public List<String> getRentedMovies() { return rentedMovies; }

    public String showCustomerDetails() {
        return "ID: " + customerID + " | Cliente: " + customerName + " | Películas rentadas: " + rentedMovies;
    }
}