package com.company;
import java.util.Scanner;

public class DoubleAndAddFive {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            // Asking user for number
            System.out.println("Please enter your number to add 5 and double it");
            int num1 = Integer.parseInt(scan.nextLine());

            // double and add 5
            int twiceFive = (num1 * 2) + 5;

            //Displaying five add and multiplication
            System.out.println("This is your result " + twiceFive);


        }

    }
