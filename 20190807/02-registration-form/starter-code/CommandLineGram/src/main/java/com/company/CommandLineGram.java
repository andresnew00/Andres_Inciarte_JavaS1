package com.company;

import java.util.Scanner;

public class CommandLineGram {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Asking user for information
        System.out.println("What is your first name?");
        String firstName = scan.nextLine();

        System.out.println("What is your last name?");
        String lastName = scan.nextLine();

        System.out.println("What is your email?");
        String email = scan.nextLine();

        System.out.println("What is your twitter handle?");
        String twitter = scan.nextLine();

        System.out.println("What is your age?");
        int age = Integer.parseInt(scan.nextLine());

        System.out.println("What is your country?");
        String country = scan.nextLine();

        System.out.println("What is your profession?");
        String profession = scan.nextLine();

        System.out.println("What is your favorite operating system?");
        String os = scan.nextLine();

        System.out.println("What is your favorite programming language?");
        String pl = scan.nextLine();

        System.out.println("What is your favorite computer scientist?");
        String cs = scan.nextLine();

        System.out.println("What is your favorite shortcut?");
        String sct = scan.nextLine();

        System.out.println("have you ever build your own computer?");
        String yn = scan.nextLine();

        System.out.println("If you could be any superhero, who would it be?");
        String hero = scan.nextLine();

        // Displaying answers
        String answers =
                        "first name: \n" + firstName + " \n" +
                        "last name: \n" + lastName + " \n" +
                        "email: \n" + email + " \n" +
                        "twitter: \n" + twitter + " \n" +
                        "age: \n" + age + " \n" +
                        "contry: \n" + country + " \n" +
                        "profession: \n" + profession + " \n" +
                        "Operating System: \n" + os + " \n" +
                        "Programming Language: \n" + pl + " \n" +
                        "Computer Scientist: \n" + cs + " \n" +
                        "short cut: \n" + sct + " \n" +
                        "build computer?: \n" + yn + " \n" +
                        "Hero: \n" + hero;

        System.out.println(answers);

    }
}
