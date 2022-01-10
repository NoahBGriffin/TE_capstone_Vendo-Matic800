package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BeverageTest {

    @Test
    public void test_dispense_and_getters() {
        VendingMachineProduct beverage = new Beverage("D4", "Triplemint", "0.75");

        assertEquals("D4", beverage.getLocation());
        assertEquals("Triplemint", beverage.getName());
        assertEquals(new BigDecimal("0.75"), beverage.getPrice());

        assertEquals("Glug Glug, Yum!", beverage.dispense());
    }
}