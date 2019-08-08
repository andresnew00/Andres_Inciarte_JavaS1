package com.company;

import java.util.Scanner;

public class UltimateQuestion {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        Integer userNumber;
        //User Input
        System.out.println("Choose a number");
        userNumber = Integer.parseInt(myScanner.nextLine());

        while (!userNumber.equals(42)) {

            // Loop Try
            System.out.println("Choose a number");
            userNumber = Integer.parseInt(myScanner.nextLine());

        }

        System.out.println("That's the number I was looking for! 42 is definitely the answer!");


    }
}
