package com.techelevator.view;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Purchase {
    private Menu menu;
    private Inventory inventory;
    private TransactionLog transactionLog;
    private Change change;
    private double currentMoney;

    public Purchase(Menu menu, Inventory inventory, TransactionLog transactionLog, Change change) {
        this.menu = menu;
        this.inventory = inventory;
        this.transactionLog = transactionLog;
        this.change = change;
        this.currentMoney = 0.0;
    }

    public void processPurchase() {
        while (true) {
            String[] purchaseMenuOptions = {
                    "Feed Money",
                    "Select Product",
                    "Finish Transaction"
            };

            String purchaseChoice = (String) menu.getChoiceFromOptions(purchaseMenuOptions);

            if (purchaseChoice.equals("Feed Money")) {
                feedMoney();
            } else if (purchaseChoice.equals("Select Product")) {
                inventory.displayInventoryCounts(); //loads inventory from orig inventory
                userProductCode(inventory.getProducts()); // pass the products list to userProductCode
            } else if (purchaseChoice.equals("Finish Transaction")) {
                finishTransaction();
            } else {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }


    public void feedMoney() {
        System.out.print("Enter the amount you want to add (in whole dollars): ");
        try {
            Scanner scanner = new Scanner(System.in);
            int moneyToAdd = scanner.nextInt();
            if (moneyToAdd > 0) {
                currentMoney += moneyToAdd;
                System.out.println("Added: $" + moneyToAdd);
                System.out.println("Current Money Provided: $" + currentMoney);
                logTransaction("FEED MONEY", moneyToAdd, currentMoney);
            } else {
                System.out.println("Invalid input. Please enter a positive amount.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private Product getProductByCode(String productCode, List<Product> inventory) {
        for (Product product : inventory) {
            if (product.getSlot().equalsIgnoreCase(productCode)) {
                return product; // Return the matching product
            }
        }
        return null; // Product not found
    }

    public void purchaseProduct(Product product) {
        if (product.getQuantity() < 1) {
            System.out.println("Sorry, the item you selected is sold out. Please pick a different item!");
        } else if (currentMoney >= product.getPrice()) {
            currentMoney -= product.getPrice();
            product.setQuantity(product.getQuantity() - 1);
            logTransaction(product.getName(), product.getPrice(), currentMoney);
            displayProductMessage(product.getType());
        } else {
            System.out.println("Insufficient funds. Please add more money.");
        }
    }

    public void displayProductMessage(String productType) {
        switch (productType.toLowerCase()) {
            case "chip":
                System.out.println("Crunch Crunch, Yum!");
                break;
            case "candy":
                System.out.println("Munch Munch, Yum!");
                break;
            case "drink":
                System.out.println("Glug Glug, Yum!");
                break;
            case "gum":
                System.out.println("Chew Chew, Yum!");
                break;
            default:
                System.out.println("Enjoy your purchase!");
        }
    }

    public void userProductCode(List<Product> inventory) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product code: ");
            String userProductCode = scanner.nextLine();
            System.out.println("User entered product code: " + userProductCode);

            Product selectedProduct = getProductByCode(userProductCode, inventory);

            if (selectedProduct != null) {
                if (selectedProduct.getQuantity() < 1) {
                    System.out.println("Sorry, the item you selected is sold out. Please pick a different item!");
                } else if (currentMoney >= selectedProduct.getPrice()) {
                    purchaseProduct(selectedProduct);
                    currentMoney -= selectedProduct.getPrice();
                    logTransaction(selectedProduct.getName(), selectedProduct.getPrice(), currentMoney);
                } else {
                    System.out.println("Insufficient funds. Please add more money.");
                }
            } else {
                System.out.println("Product code not found in the inventory: " + userProductCode);
            }
        }
    }


    public void finishTransaction() {
        change.makeChange(currentMoney);
        logTransaction("GIVE CHANGE", currentMoney, 0.0);
        System.out.println("Transaction complete. Your change is: $" + currentMoney);
        currentMoney = 0.0;
    }

    private void logTransaction(String function, double amount, double balance) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Log.txt", true))) {
            String timeStamp = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date());
            writer.println(timeStamp + " " + function + ": $" + String.format("%.2f", amount) + " $" + String.format("%.2f", balance));
        } catch (IOException e) {
            System.out.println("Error logging to the file: " + e.getMessage());
        }
    }
}
