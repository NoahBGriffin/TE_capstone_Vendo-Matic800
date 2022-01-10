package com.techelevator.application;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public abstract class Log {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy HH:mm:ss a");
    private static LocalDateTime now = LocalDateTime.now();
    private static File audit = new File("audit.txt");

    public static void logAction(String action, BigDecimal balanceBefore, BigDecimal balanceAfter) {

        try (PrintWriter pw = new PrintWriter(new FileOutputStream("audit.txt", true))) {

            pw.println(">" + dtf.format(now) + " " + action + " \\$" + balanceBefore + " \\$" + balanceAfter);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void createSalesReport(List<VendingMachineProduct> products) {
        File file = new File("sales_report.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            System.out.println("Generating sales report...");
            for (VendingMachineProduct product : products) {
                BigDecimal amountSold = new BigDecimal( VendingMachine.MAX_STOCK - product.getInventoryCount());
                BigDecimal dollarAmountSold = product.getPrice().multiply(amountSold).setScale(2, RoundingMode.HALF_UP);
                pw.println(product.getName() + "|" + dollarAmountSold);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
