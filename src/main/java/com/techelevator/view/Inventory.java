package com.techelevator.view;
import java.io.*;
import java.util.*;

public class Inventory {

    private List<String> inventoryCounts;

    public Inventory() {
        inventoryCounts = new ArrayList<>();
        products = new ArrayList<>(); // Initialize the products list

    }
    public List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void addItemToInventory(String item) {
        inventoryCounts.add(item);
    }

    // Method to display the inventoryCounts List
    public List<String> displayInventoryCounts() {
        //This method is blank for the if statement
        for (String part : inventoryCounts) {
            System.out.println(part);
            if (!inventoryCounts.isEmpty()) {

            } else {
                System.out.println("Inventory is empty.");
            }}
        return inventoryCounts;
    }


    public Inventory getInventoryObject() {
        return this;
    }
    public void loadInventoryFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                Product product = parseProduct(line);
                if (product != null) {
                    products.add(product);
                }
            }
        }
    }

    public Product parseProduct(String line) {
        // split the line into components
        String[] parts = line.split("\\|");

        // check if the line has enough parts to create a Product
        if (parts.length >= 4) {
            String slot = parts[0].trim();
            String name = parts[1].trim();
            double price = Float.parseFloat(parts[2].trim());
            String type = parts[3].trim();

            // create a new Product object and return it
            try {
                return new Product(slot, name, price, type);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
