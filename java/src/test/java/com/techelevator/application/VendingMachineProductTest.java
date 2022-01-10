package com.techelevator.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineProductTest {

    @Test
    public void removeItem() {

        VendingMachineProduct vendingMachineProduct = new Gum("D4", "Triplemint", "1.50");

        int expectedResult = 4;
        String expectedResult2 = "Chew Chew, Yum!";

        assertEquals(expectedResult, vendingMachineProduct.removeItem());
        assertEquals(expectedResult2, vendingMachineProduct.dispense());

    }
}