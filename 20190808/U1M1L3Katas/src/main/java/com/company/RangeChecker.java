package com.company;

import java.util.Scanner;

public class RangeChecker {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //User Input
        int userNumber = 0;

        //User first try
        System.out.println("Enter a number between 15 and 32");
        userNumber = myScanner.nextInt();

        while (userNumber < 15 || userNumber > 32) {

            // Loop Try
            System.out.println("Enter a number between 15 and 32");
            userNumber = myScanner.nextInt();

        }

        System.out.println(userNumber);

    }
}
