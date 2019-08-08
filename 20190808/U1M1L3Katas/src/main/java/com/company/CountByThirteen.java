package com.company;

import java.util.Scanner;

public class CountByThirteen {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number you want to count by 2");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        // change ++ to += the number you want to increase for
        for (int i = 0; i <= userNumber; i += 13) {

            System.out.println(i);
        }

    }
}