import java.util.Random;
import java.util.Scanner;

public class NumberGuesserWithCounter {
        public static void main(String[] args) {
            Scanner myScanner = new Scanner(System.in);
            Random randomGenerator = new Random();

            int randomInt;
            //adding counter
            int counter = 0;


            randomInt = randomGenerator.nextInt(10) + 1;


            System.out.println("I'm thinking of a number from 1 to 10. Try to Guess it!");

            // That means it will keep looping as long as the guess is different from the secret number.
            int userGuess = Integer.parseInt(myScanner.nextLine());
            System.out.println("Your guess: " + userGuess);

            // Use a  while loop.
            while (userGuess != randomInt) {
                System.out.println("That is incorrect. Guess again.");
                userGuess = Integer.parseInt(myScanner.nextLine());
                counter++;
            }

            System.out.println("That's right! You are a Good Guesser ");
            System.out.println("It only took you "+ counter + " tries.");
        }
    }

