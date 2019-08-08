package com.company;

import java.util.Scanner;

public class EvenOrOdd {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        System.out.println("Find out if number is even or odd");
        int userNumber = Integer.parseInt(myScanner.nextLine());

        // if the reminder when you divide by 2 is 0 then is even
        if ((userNumber % 2) == 0) {
            System.out.println("number is even");
        } else {
            System.out.println("number is odd");
        }


    }
}
