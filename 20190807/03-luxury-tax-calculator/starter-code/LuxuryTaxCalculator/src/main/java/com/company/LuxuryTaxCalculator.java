package com.company;
import java.util.Scanner;

public class LuxuryTaxCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Player's salary
        System.out.println("What is the salary of Player 1?");
        int playerOne = Integer.parseInt(scan.nextLine());
        System.out.println("Player one makes " + playerOne);

        System.out.println("What is the salary of Player 2?");
        int playerTwo = Integer.parseInt(scan.nextLine());
        System.out.println("Player one makes " + playerTwo);

        System.out.println("What is the salary of Player 3?");
        int playerThree = Integer.parseInt(scan.nextLine());
        System.out.println("Player one makes " + playerThree);

        // Total Salary for the 3 players
        int totalSalary = (playerOne + playerTwo + playerThree);
        System.out.println("Total Player Salary: " + totalSalary);
        int limitAmount = 40000000;

        //conditional when salary is more than 40000000
        if (totalSalary >= limitAmount) {
            // 18% taxes
            double luxuryPayPercent = 0.18;
            // the amount of money above the limit
            double difference = totalSalary - limitAmount;
            double luxuryPay = difference * luxuryPayPercent;

            System.out.println("Luxury Tax: " + luxuryPay);

        }
    }
}
