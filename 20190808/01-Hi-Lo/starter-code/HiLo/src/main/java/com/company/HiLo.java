package com.company;

import java.util.Scanner;
import java.util.Random;

public class HiLo {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("Welcome to Hi-Low!");
        // User name prompt
        System.out.println("What is your name?");
        String name = myScanner.nextLine();

        System.out.println("OK, " + name + ", here are the rules:");

        int randomNumber = randomGenerator.nextInt(101) + 1;
        int guess;
        int counter = 1;

        //this do while loop allows to use previus code and the apply conditions after
        do {
            System.out.println("Pick a number between 1 - 100");
            guess = myScanner.nextInt();
            counter++;


            if (guess == randomNumber) {
                System.out.println("Congratulations, " + name + "! You win!");
                System.out.println("It took you " + counter + " guesses to find my number!");
            } else if (guess < randomNumber) {
                System.out.println("Too low!");
            } else if (guess > randomNumber) {
                System.out.println("Too high!");
            }

        } while (guess != randomNumber);


    }
}
