package com.company;

import java.util.Scanner;

public class FavoriteProgrammingLanguage {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userAnswer;
        //User Input
        System.out.println("What is your favorite programming language?");
        userAnswer = myScanner.nextLine();

        while (!userAnswer.equals("Java")) {

            // Loop Try
            System.out.println("What is your favorite programming language?");
            userAnswer = myScanner.nextLine();

        }

        System.out.println("That's what I was looking for! Java is definitely the answer!");

    }
}
