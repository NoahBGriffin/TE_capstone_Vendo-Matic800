package com.techelevator.application;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingMachineTest {

    private VendingMachine test;

    @Before
    public void setup() {
        test = new VendingMachine("vendingmachinetest");
    }

    @Test
    public void test_vendingmachine_initialization() {
        assertEquals(BigDecimal.ZERO, test.getBalance());

        List<VendingMachineProduct> testList = test.getInventory();
        VendingMachineProduct gum = new Gum("D4", "Triplemint", "0.75");
        assertEquals(gum.getName(), testList.get(0).getName());
        assertEquals(gum.getPrice(), testList.get(0).getPrice());
    }

    @Test
    public void test_is_correct_change_given() {
        String expectedResult = "Your change is 1 Quarter(s) 1 Dime(s) 1 Nickel(s).";
        assertEquals(expectedResult, test.giveChange(new BigDecimal("0.40")));

        String expectedResult2 = "Your change is ";
        assertEquals(expectedResult2, test.giveChange(BigDecimal.ZERO));
    }

    @Test
    public void update_vending_machine_balance() {
        BigDecimal expectedResult = new BigDecimal("5.00");
        test.addBalance(new BigDecimal("5.00"));
        assertEquals(expectedResult, test.getBalance());

        BigDecimal expectedResult2 = new BigDecimal("0.00");
        test.subtractBalance(new BigDecimal("5.00"));
        assertEquals(expectedResult2, test.getBalance());
    }



}