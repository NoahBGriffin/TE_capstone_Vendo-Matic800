package com.techelevator.application;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class FundsTest {

    @Test
    public void test_change_funds() {
        Funds test = new Funds();
        test.addFunds("1");
        assertEquals(new BigDecimal("1"), test.getCustomerBalance());

        test.subtractFunds(new BigDecimal("0.50"));
        assertEquals(new BigDecimal("0.50"), test.getCustomerBalance());

        test.resetFunds();
        assertEquals(BigDecimal.ZERO, test.getCustomerBalance());
    }

}