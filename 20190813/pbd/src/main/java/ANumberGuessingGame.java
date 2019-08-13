import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int randomInt;

        //Modify your incredibly stupid number-guessing game to actually pick a random number from 1 to 10 and have the user
        randomInt = randomGenerator.nextInt(10) + 1;

        // try to guess that. Tell them if they get it right or wrong, and if they get it wrong,
        System.out.println("I'm thinking of a number from 1 to 10.");
        int userGuess = Integer.parseInt(myScanner.nextLine());
        System.out.println("Your guess: " + userGuess);

        // show them what the random number was.
        if (userGuess == randomInt) {
            System.out.println("That's right!  My secret number was " + userGuess + "!");
        } else {
            System.out.println("Sorry, but I was really thinking of " + randomInt);
        }
        //They will still only get one try.
    }
}
