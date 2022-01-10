package com.techelevator.ui;

import com.techelevator.application.VendingMachine;
import com.techelevator.application.VendingMachineProduct;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayVendingMachine(List<VendingMachineProduct> myMachine) {

        for (VendingMachineProduct entry : myMachine) {
            String count = entry.getInventoryCount() + "";
            if (count.equals("0")) count = "SOLD OUT";
            else count = count + " in stock";
            System.out.println(entry + " >> " + count);
        }
    }


}
