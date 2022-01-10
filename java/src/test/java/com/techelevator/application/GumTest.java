package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class GumTest {

    @Test
    public void dispense() {

        VendingMachineProduct gum = new Gum("D4", "Triplemint", "0.75");

        assertEquals("D4", gum.getLocation());
        assertEquals("Triplemint", gum.getName());
        assertEquals(new BigDecimal("0.75"), gum.getPrice());

        assertEquals("Chew Chew, Yum!", gum.dispense());
    }
}