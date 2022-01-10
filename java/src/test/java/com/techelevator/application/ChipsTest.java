package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ChipsTest {

    @Test
    public void test_dispense_and_getters() {
        VendingMachineProduct chips = new Chips("D4", "Triplemint", "0.75");

        assertEquals("D4", chips.getLocation());
        assertEquals("Triplemint", chips.getName());
        assertEquals(new BigDecimal("0.75"), chips.getPrice());

        assertEquals("Crunch Crunch, Yum!", chips.dispense());
    }
}