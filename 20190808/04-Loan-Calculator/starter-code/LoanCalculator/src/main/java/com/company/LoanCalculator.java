package com.company;

import java.util.Scanner;

public class LoanCalculator {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // User Input
        System.out.println("What is the loan amount?");
        double loan = Double.parseDouble(myScanner.nextLine());

        System.out.println("How long is the term in months?");
        double term = Double.parseDouble(myScanner.nextLine());

        System.out.println("What is the annual interest rate?");
        double rate = Double.parseDouble(myScanner.nextLine());

        //turning rate into percent
        double annualRate = rate / 100;
        // changing rate into monthly rate
        double monthlyRate = annualRate / 12;
        // power of term
        double rateMaths = Math.pow(monthlyRate + 1, term);
        // Fixed Monthly Payment P = L[c(1 + c)n]/[(1 + c)n - 1]
        double payment = loan * (monthlyRate * rateMaths) / (rateMaths - 1);

        System.out.println(payment);


    }
}
