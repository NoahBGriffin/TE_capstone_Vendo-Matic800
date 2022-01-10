package com.techelevator.application;

public class Beverage extends VendingMachineProduct {

    public Beverage(String location, String name, String price) {
        super(location, name, price);
    }

    public String dispense() {
        int count = super.removeItem();
        if (count == -1) return "SOLD OUT";
        return "Glug Glug, Yum!";
    }
}
