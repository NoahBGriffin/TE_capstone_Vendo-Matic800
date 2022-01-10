package com.techelevator.ui;

import com.techelevator.application.Funds;
import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * <p>
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "display";
        } else if (option.equals("2")) {
            return "purchase";
        } else if (option.equals("3")) {
            return "exit";
        } else if (option.equals("4")) {
            return "Sales Report";
        } else {
            return "";
        }

    }

    public static String getPurchaseOption(Funds customerBalance) {
        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");

        System.out.println("\nCurrent Money Provided: \\$" + customerBalance.getCustomerBalance());
        System.out.print("\nPlease select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
            return "Feed";
        } else if (option.equals("2")) {
            return "Select";
        } else if (option.equals("3")) {
            return "exit";
        } else return "";
    }

    public static BigDecimal getFeedAmount(Funds customerBalance) {
        boolean keepGoing = true;
        BigDecimal sum = BigDecimal.ZERO;
        do {
            System.out.print("Please enter a whole dollar amount or enter \"Q\" to quit: $");

            String amount = scanner.nextLine();

            if (amount.equalsIgnoreCase("q")) {
                keepGoing = false;
            } else {
                sum = sum.add(new BigDecimal(amount));
            }

        } while (keepGoing);

        return sum;
    }

    public static String getUserInput() {
        return scanner.nextLine().trim();
    }




}
