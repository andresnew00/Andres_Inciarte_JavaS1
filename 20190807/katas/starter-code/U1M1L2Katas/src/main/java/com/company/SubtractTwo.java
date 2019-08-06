package com.company;
import java.util.Scanner;
public class SubtractTwo {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Asking user for numbers
        System.out.println("Please enter your number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter your number");
        int num2 = Integer.parseInt(scan.nextLine());

        // substraction of numbers
        int subs = num1 - num2;

        //Displaying result
        System.out.println("This is your result " + subs);

    }
}
