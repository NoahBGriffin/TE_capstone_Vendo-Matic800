package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CandyTest {

    @Test
    public void test_dispense_and_getters() {

        VendingMachineProduct candy = new Candy("D4", "Triplemint", "0.75");

        assertEquals("D4", candy.getLocation());
        assertEquals("Triplemint", candy.getName());
        assertEquals(new BigDecimal("0.75"), candy.getPrice());

        assertEquals("Munch Munch, Yum!", candy.dispense());
    }


}