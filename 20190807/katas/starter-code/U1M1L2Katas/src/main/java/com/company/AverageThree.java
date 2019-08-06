package com.company;
import java.util.Scanner;

public class AverageThree {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Asking user for numbers
        System.out.println("Please enter your number");
        int num1 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter your number");
        int num2 = Integer.parseInt(scan.nextLine());

        System.out.println("Please enter your number");
        int num3 = Integer.parseInt(scan.nextLine());

        // finding average number
        double sum = num1 + num2 + num3;
        double count = 3;
        double average = sum / count;

        //Displaying average
        System.out.println("This is your result ");
        System.out.printf("%2f", average);


    }
}
