package com.techelevator.application;

import java.math.BigDecimal;

public abstract class VendingMachineProduct {

    private String name;
    private String location;
    private BigDecimal price;
    private int inventoryCount;

    public VendingMachineProduct(String location, String name, String price) {
        this.location = location;
        this.name = name;
        this.price = new BigDecimal(price);
        this.inventoryCount = 5;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public String toString() {
        return this.location + " | " + this.name + " | $" + this.price;
    }

    public abstract String dispense();

    public int removeItem() {
        if (this.inventoryCount > 0) {
            this.inventoryCount--;
            return this.inventoryCount;
        }
        else return -1;
    }
}
