package com.techelevator.application;

public class Gum extends VendingMachineProduct {

    public Gum(String location, String name, String price) {
        super(location, name, price);
    }

    public String dispense() {

        int count = super.removeItem();
        if (count == -1) return "SOLD OUT";
        return "Chew Chew, Yum!";
    }
}
