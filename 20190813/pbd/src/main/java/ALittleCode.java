import java.util.Scanner;

public class ALittleCode {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int score = 0;
        //Write an interactive quiz. It should ask the user three multiple-choice or true/false
        // questions about something. It must keep track of how many they get wrong, and print out a "score" at the end.

        //user has no choice it has to take the quiz
        System.out.println("Are you ready for a quiz?");
        String userAnswer = myScanner.nextLine();

        System.out.println("Okay, here it comes!");

        System.out.println("Q1) What is the capital of Alaska?\n" +
                "\t1) Melbourne\n" +
                "\t2) Anchorage\n" +
                "\t3) Juneau\n");
        int userAnswer1 = Integer.parseInt(myScanner.nextLine());

        if (userAnswer1 == 3) {
            System.out.println("That's correct!");
            score++;
        } else {
            System.out.println("Sorry that's wrong!");
        }

        System.out.println("Q2) Can you store the value \"cat\" in a variable of type int?\n" +
                "\t1) yes\n" +
                "\t2) no");
        int userAnswer2 = Integer.parseInt(myScanner.nextLine());

        if (userAnswer2 == 2) {
            System.out.println("That is correct!");
            score++;
        } else {
            System.out.println("Sorry, \"cat\" is a string. ints can only store numbers.");
        }

        System.out.println("Q3) What is the result of 9+6/3?\n" +
                "\t1) 5\n" +
                "\t2) 11\n" +
                "\t3) 15/3");
        int userAnswer3 = Integer.parseInt(myScanner.nextLine());

        if (userAnswer3 == 2) {
            System.out.println("That is correct!");
            score++;
        } else {
            System.out.println("Sorry that is not the right answer");
        }

        System.out.println("Overall, you got " + score + " out of 3 correct.\n" +
                "Thanks for playing!");

    }
}
