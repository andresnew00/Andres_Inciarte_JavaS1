package com.company;

import java.util.Scanner;

public class CountTo {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number you want to count");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        for (int i = 0; i <= userNumber; i++) {
            System.out.println(i);
        }
    }
}
