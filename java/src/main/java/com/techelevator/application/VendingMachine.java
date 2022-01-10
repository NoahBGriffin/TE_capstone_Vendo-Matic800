package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
//import org.graalvm.compiler.replacements.SnippetTemplate;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingMachine {
    private BigDecimal balance;
    private List<VendingMachineProduct> inventory = new ArrayList<>();
    private File inventoryFile;
    private Funds customerBalance = new Funds();

    static final int MAX_STOCK = 5;

    public VendingMachine(String fileName) {
        this.balance = BigDecimal.ZERO;
        this.inventoryFile = new File(fileName);
        stockInventory();
    }

    public void run() {
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                UserOutput.displayVendingMachine(this.inventory);
            } else if (choice.equals("purchase")) {
                purchase();
            } else if (choice.equals("exit")) {
                System.out.println("Thank you! Goodbye");
                break;
            } else if (choice.equals("Sales Report")) {
                Log.createSalesReport(inventory);
            }
        }
    }

    public void purchase() {

        boolean keepGoing = true;
        BigDecimal moneyGiven = new BigDecimal("0.00");
        do {
            String choice = UserInput.getPurchaseOption(customerBalance);

            if (choice.equals("Feed")) {

                BigDecimal moneyFed = UserInput.getFeedAmount(customerBalance);
                customerBalance.addFunds(moneyFed);
                Log.logAction("FEED MONEY:", this.balance, this.balance.add(moneyFed));
                this.addBalance(moneyFed);

            } else if (choice.equals("Select")) {

                UserOutput.displayVendingMachine(this.inventory);
                System.out.print("Please enter product code: ");
                String productChoice = UserInput.getUserInput();
                dispenseProduct(productChoice);

            } else if (choice.equals("exit")) {
                System.out.println(giveChange(customerBalance.getCustomerBalance()));
                keepGoing = false;
            }


        } while (keepGoing);
    }

    public void dispenseProduct(String productCode) {

        boolean itemFound = false;
        for (VendingMachineProduct item : this.inventory) {
            if (productCode.equalsIgnoreCase(item.getLocation())) {
                if (customerBalance.getCustomerBalance().compareTo(item.getPrice()) == -1 ) {
                    System.out.println("Not enough money was given!");
                    itemFound = true;
                    break;
                }
                String dispenseResult = item.dispense();
                itemFound = true;
                if (dispenseResult.equals("SOLD OUT")) {
                    System.out.println("This item is out of stock!");
                    break;
                } else {
                    Log.logAction(item.getName() + " " + item.getLocation(), this.getBalance(),
                            this.getBalance().subtract(item.getPrice()));
                    customerBalance.subtractFunds(item.getPrice());
                    this.subtractBalance(item.getPrice());
                    System.out.println(item.getName() + " " + item.getPrice());
                    System.out.println("Remaining balance: $" + customerBalance.getCustomerBalance());
                    System.out.println(dispenseResult);
                }
            }
        }
        if (!itemFound) {
            System.out.println(productCode + " not found!");
        }
    }

    public String giveChange(BigDecimal moneyGiven) {

        String change = "Your change is ";
        int quarterCount = 0;
        int dimeCount = 0;
        int nickelCount = 0;
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal nickel = new BigDecimal("0.05");

        while (moneyGiven.compareTo(quarter) != -1) {
            moneyGiven = moneyGiven.subtract(quarter);
            quarterCount++;
        }
        while (moneyGiven.compareTo(dime) != -1) {
            moneyGiven = moneyGiven.subtract(dime);
            dimeCount++;
        }
        while (moneyGiven.compareTo(nickel) != -1) {
            moneyGiven = moneyGiven.subtract(nickel);
            nickelCount++;
        }

        if (quarterCount > 0) {
            change += quarterCount + " Quarter(s) ";
        }
        if (dimeCount > 0) {
            change += dimeCount + " Dime(s) ";
        }
        if (nickelCount > 0) {
            change += nickelCount + " Nickel(s).";
        }

        Log.logAction("GIVE CHANGE:", this.balance, this.balance.subtract(moneyGiven));

        customerBalance.resetFunds();

        return change;
    }

    public void addBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void subtractBalance(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void stockInventory() {

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(inventoryFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (fileScanner.hasNextLine()) {
            String[] currentLine = fileScanner.nextLine().split("\\|");
            String foodType = currentLine[3];
            if (foodType.equals("Chip")) {
                VendingMachineProduct chip = new Chips(currentLine[0], currentLine[1], currentLine[2]);
                inventory.add(chip);
            } else if (foodType.equals("Candy")) {
                VendingMachineProduct candy = new Candy(currentLine[0], currentLine[1], currentLine[2]);
                inventory.add(candy);
            } else if (foodType.equals("Gum")) {
                VendingMachineProduct gum = new Gum(currentLine[0], currentLine[1], currentLine[2]);
                inventory.add(gum);
            } else if (foodType.equals("Drink")) {
                VendingMachineProduct drink = new Beverage(currentLine[0], currentLine[1], currentLine[2]);
                inventory.add(drink);
            }
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<VendingMachineProduct> getInventory() {
        return inventory;
    }
}
