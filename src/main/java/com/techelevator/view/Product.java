package com.techelevator.view;

import java.io.FileNotFoundException;

public class Product {
    // Declaring variables, Getters, and Setters
   private String slot;
    private String name;
    private double price;
    private String type;
    private int quantity;
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


//Creating Product constructor
    public Product(String slot, String name, Double price, String type) throws FileNotFoundException {
        this.slot = slot;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = 5;
    }

    public void Restock(){
        setQuantity(5);
    }
    /*public class VendingMachine {
        private List<Product> inventory;

        public VendingMachine() {
            inventory = new ArrayList<>();

            for (Product product: inventory) {
                System.out.println(product.getName());
            }

*/

        }


