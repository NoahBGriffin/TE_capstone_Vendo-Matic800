package com.techelevator.application;

import java.math.BigDecimal;

public class Funds {

    private BigDecimal customerBalance = BigDecimal.ZERO;

    public BigDecimal getCustomerBalance() {
        return this.customerBalance;
    }

    public void resetFunds() {
        this.customerBalance = BigDecimal.ZERO;
    }

    public void addFunds(String amount) {

        try {
            Integer amountInt = Integer.parseInt(amount);
            if (amountInt < 1) {
                throw new IllegalArgumentException("Please enter a positive amount!");
            } else {
                this.customerBalance = this.customerBalance.add(new BigDecimal(amount));
                System.out.println("$" + amount + " added.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a whole dollar amount");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addFunds(BigDecimal amount) {
        this.customerBalance = this.customerBalance.add(amount);
    }

    public void subtractFunds(BigDecimal amount) {
        this.customerBalance = this.getCustomerBalance().subtract(amount);
    }
}
