package com.techelevator.view;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductList extends Product{
    public ProductList(String slot, String name, double price, String type) throws FileNotFoundException {
        super(slot, name, price, type);
    }
    public class VendingMachine {

        private List<Product> inventory;

        public VendingMachine() {
            inventory = new ArrayList<>();

            for (Product product : inventory) {
                System.out.println(product.getName() + " " + getQuantity());
            }
        }
    }
}
