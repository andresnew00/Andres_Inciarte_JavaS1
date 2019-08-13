import java.util.Random;
import java.util.Scanner;

public class HiloWithLimitedTries {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        int counterLives = 7;
        int count = 1;

        //Write a program that picks a random number from 1-100.
        int randomnumber = randomGenerator.nextInt(100) + 1;

        System.out.println("I'm thinking of a number between 1-100.  You have 7 guesses.");
        int userGuess = Integer.parseInt(myScanner.nextLine());

        // The user keeps guessing as long as their guess is wrong, and they've guessed less than 7 times.
        while (counterLives > 0 && userGuess != randomnumber){
            if (userGuess < randomnumber) {
                // If their guess is lower than the number, say "Too low."
                System.out.println("Guess # " + count++ + " : " + userGuess);
                System.out.println("Sorry, you are too low.");
                userGuess = Integer.parseInt(myScanner.nextLine());
            } else if (userGuess > randomnumber) {
                // If their guess is higher than the number, say "Too high."
                System.out.println("Guess # " + count++ + " : " + userGuess);
                System.out.println("Sorry, that guess is too high.");
                userGuess = Integer.parseInt(myScanner.nextLine());
            }
            counterLives--;
        }
        // When they get it right, the game stops.
        // Or, if they hit seven guesses, the game stops even if they never got it right.
        if (counterLives == 0) {
            System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
        } else if (userGuess == randomnumber) {
            System.out.println("You guessed it!  What are the odds?!?");
        }
    }
}
