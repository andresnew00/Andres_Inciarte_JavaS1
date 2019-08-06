package com.company;
import java.util.Scanner;

public class AddThirteen {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Asking user for number
        System.out.println("Please enter your number to add 13 to it");
        int num1 = Integer.parseInt(scan.nextLine());

        // add 13
        int plus13 = num1 + 13;

        //Displaying sum of 13
        System.out.println("This is your result " + plus13);


    }
}
