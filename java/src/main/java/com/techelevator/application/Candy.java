package com.techelevator.application;

public class Candy extends VendingMachineProduct {

    public Candy(String location, String name, String price) {
        super(location, name, price);
    }

    public String dispense() {

        int count = super.removeItem();
        if (count == -1) return "SOLD OUT";
        return "Munch Munch, Yum!";
    }
}
