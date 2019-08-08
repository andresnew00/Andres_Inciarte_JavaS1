package com.company;

import java.util.Scanner;

public class YourAgeCan {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        //asking for age
        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());

        // 18 or older
        if (age >= 18 && age <= 20) {
            System.out.println("vote");
            // 21 and older
        } else if (age >= 21 && age <= 34) {
            System.out.println("vote");
            System.out.println("alcohol");
            // Be President 35+
        } else if (age >= 35 && age <= 54) {
            System.out.println("vote");
            System.out.println("alcohol");
            System.out.println("president");
            // 55 and older
        } else if (age >= 55 && age <= 64) {
            System.out.println("vote");
            System.out.println("alcohol");
            System.out.println("president");
            System.out.println("aarp");
        } else if (age >= 65 && age <= 79) {
            System.out.println("vote");
            System.out.println("alcohol");
            System.out.println("president");
            System.out.println("aarp");
            System.out.println("retire");
        } else if (age >= 80 && age <= 99) {
            System.out.println("vote");
            System.out.println("alcohol");
            System.out.println("president");
            System.out.println("aarp");
            System.out.println("retire");
            System.out.println("octogenarian");
        } else if (age >= 100) {
            System.out.println("vote");
            System.out.println("alcohol");
            System.out.println("president");
            System.out.println("aarp");
            System.out.println("retire");
            System.out.println("century");
        }

    }
}
