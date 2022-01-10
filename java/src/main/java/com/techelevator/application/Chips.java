package com.techelevator.application;

public class Chips extends VendingMachineProduct {

    public Chips(String location, String name, String price) {
        super(location, name, price);
    }

    @Override
    public String dispense() {

        int count = super.removeItem();
        if (count == -1) return "SOLD OUT";
        return "Crunch Crunch, Yum!";
    }
}
