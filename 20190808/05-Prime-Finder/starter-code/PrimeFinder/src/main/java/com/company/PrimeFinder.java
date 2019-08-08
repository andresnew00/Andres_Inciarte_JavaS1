package com.company;

import java.util.Scanner;

public class PrimeFinder {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Please enter the limit number to find Prime");
        int primeNumberLimit = Integer.parseInt(myScanner.nextLine());

        for (int i = 1; i <= primeNumberLimit; i++) {





            System.out.println(i);
        }

    }
}
