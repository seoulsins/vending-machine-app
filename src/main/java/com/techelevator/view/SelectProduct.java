package com.techelevator.view;
import java.util.*;

public class SelectProduct extends Inventory {
//    private Inventory inventory; // instance variable to store the Inventory
//    private List<Product> products;
//
//    // Constructor that accepts an Inventory instance as a parameter
//    public SelectProduct(Inventory inventory) {
//        this.inventory = inventory; // Store the passed Inventory instance
//        this.products = inventory.getProducts(); // Initialize products here
//    }
//
//    public void displayAvailableProducts() {
//        if (products == null || products.isEmpty()) {
//            System.out.println("No items available.");
//        } else {
//            System.out.println("Available Products:");
//            for (Product product : products) {
//                System.out.println(product.getName());
//            }
//        }
//    }
//
//    //
//    public List<String> getSlot() {
//        List<String> productCodes = new ArrayList<>();
//        for (Product product : products) {
//            productCodes.add(product.getSlot());
//        }
//        return productCodes;
//    }
//
//    public void userProductCode() {
//        while (true) {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter the product code: ");
//            String userProductCode = scanner.nextLine();
//
//            // Find the product with the matching code
//            Product selectedProduct = null;
//            for (Product product : products) {
//                if (product.getSlot().equalsIgnoreCase(userProductCode)) {
//                    selectedProduct = product;
//                    break; // Exit the loop once a match is found
//                }
//            }
//
//            if (selectedProduct != null) {
//                // The selectedProduct variable is properly initialized and not null
//                System.out.println("Selected Product: " + selectedProduct.getName());
//                System.out.println("Price: $" + selectedProduct.getPrice());
//                System.out.println("Item Type: " + selectedProduct.getType());
//                if (selectedProduct.getQuantity() < 1) {
//                    System.out.println("Sorry, the item you selected is sold out. Please pick a different item!");
//                } else {
//                    // Take the money and subtract it from the current balance here.
//                    selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);
//                    if (selectedProduct.getType().contains("chip")) {
//                        System.out.println("Crunch Crunch, Yum!");
//                    } else if (selectedProduct.getType().contains("candy")) {
//                        System.out.println("Munch Munch, Yum!");
//                    } else if (selectedProduct.getType().contains("drink")) {
//                        System.out.println("Glug Glug, Yum!");
//                    } else if (selectedProduct.getType().contains("gum")) {
//                        System.out.println("Chew Chew, Yum!");
//                    }
//                    // Logging can go here!
//                }
//            } else {
//                // The user input is not a valid product code
//                System.out.println("Invalid product code. Please enter a valid code.");
//                // You can handle this case by displaying an error message or returning to the main menu
//            }
//        }
//    }
}
