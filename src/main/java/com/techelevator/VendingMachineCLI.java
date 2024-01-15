package com.techelevator;

import com.techelevator.view.*;

import java.io.IOException;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;
	private Inventory inventory;
	private TransactionLog transactionLog;
	private Change change;

	public VendingMachineCLI(Menu menu, Inventory inventory, TransactionLog transactionLog, Change change) {
		this.menu = menu;
		this.inventory = inventory;
		this.transactionLog = transactionLog;
		this.change = change;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				inventory.displayInventoryCounts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				handlePurchase();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Have a nice day!");
				break;
			}
		}
	}

	private void handlePurchase() {
		Purchase purchase = new Purchase(menu, inventory, transactionLog, change);
		purchase.processPurchase();
	}

	public static void main(String[] args) throws IOException {
		Menu menu = new Menu(System.in, System.out);
		Inventory inventory = new Inventory();
		inventory.loadInventoryFromFile("vendingmachine.csv");
		TransactionLog transactionLog = new TransactionLog();
		Change change = new Change();
		VendingMachineCLI cli = new VendingMachineCLI(menu, inventory, transactionLog, change);
		cli.run();
	}
}
