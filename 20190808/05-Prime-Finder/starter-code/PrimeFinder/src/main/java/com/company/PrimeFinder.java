package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // User Input
        System.out.println("Please enter a number: ");

        //User Choice for max number
        int userNumber = Integer.parseInt(scanner.nextLine());

        for (int x = 2; x <= userNumber; x++) {

            boolean prime = true;
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0) {
                    prime = false;
                    break;
                }
            }
            if ( prime == true)
                System.out.println(x);
        }
    }
}
