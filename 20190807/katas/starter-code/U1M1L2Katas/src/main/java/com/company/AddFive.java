package com.company;
import java.util.Scanner;
public class AddFive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Asking user for the 5 numbers
        System.out.println("Please enter the first number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter the second number");
        int num2 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter the third number");
        int num3 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter the fourth number");
        int num4 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter the fifth number");
        int num5 = Integer.parseInt(scan.nextLine());

        //Adding all numbers
        int sum = num1 + num2 + num3 + num4 + num5;

        //Displaying sum of all 5 numbers
        System.out.println("The Sum of the numbers is " + sum);


    }
}
