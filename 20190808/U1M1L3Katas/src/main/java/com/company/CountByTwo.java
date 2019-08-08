package com.company;

import java.util.Scanner;

public class CountByTwo {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        System.out.println("Enter a number you want to count by 2");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        // change ++ to += the number you want to increase for
        for (int i = 0; i <= userNumber; i += 2) {

            System.out.println(i);
        }
    }
}
