package com.company;
import java.util.Scanner;

public class AgeAgain {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        //asking for age
        System.out.println("What is your age?");
        int age = Integer.parseInt(myScanner.nextLine());

        // Less than 14
        if (age < 14) {
            System.out.println("What grade are you on?");
            String grade = myScanner.nextLine();
            System.out.println("Wow! " + grade + " grade - that sounds exciting!");
        // between 14 and 18
        } else if (age >= 14 && age <= 18) {
            System.out.println("Are you planning on going to college");
            String answer = myScanner.nextLine();
            if (answer.equals("yes")) {
                System.out.println("What college are you going to?");
                String college = myScanner.nextLine();
                System.out.println(college + " is a great school!");
            } else if (answer.equals("no")) {
                System.out.println("What are you doing after high school?");
                String doing = myScanner.nextLine();
                System.out.println("Wow, " + doing + " sounds like a plan!");
            }
        // 18 and older
        } else if (age > 18) {
            System.out.println("What is your job?");
            String job = myScanner.nextLine();
            System.out.println(job + " sounds like a great job!");
        }




//        Write a program that asks for the user's age and then asks a follow-up question based on the value:
//                * Less than 14: Ask what grade they're in and then prints "Wow! [user answer] grade - that sounds exciting!"
//                * Between 14 and 18 (inclusive): Ask if they're planning to go to college.  If the answer is "yes" (all lowercase), ask what college and then print "[user answer] is a great school!".  If the answer is "no" (all lowercase), ask what they want to do after high school, then print "Wow, <user answer> sounds like a plan!"
//                * Greater than 18: Ask what their job is, then print "[user answer] sounds like a great job!"


    }
}
