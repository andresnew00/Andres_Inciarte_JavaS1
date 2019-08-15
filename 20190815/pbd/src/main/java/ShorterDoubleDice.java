import java.util.Random;

public class ShorterDoubleDice {
    public static void main(String[] args) {

        //My code was already using a do while loop ...

        Random randomGenerator = new Random();
        int roll1;
        int roll2;
        int sum;

        System.out.println("HERE COMES THE DICE!");
        do {
            //Write a program that simulates a dice roll by picking a random number from 1-6
            roll1 = randomGenerator.nextInt(6) + 1;
            System.out.println("Roll #1: " + roll1);

            // and then picking a second random number from 1-6. Add the two values together,
            roll2 = randomGenerator.nextInt(6) + 1;
            System.out.println("Roll #2: " + roll2);

            //sum
            sum = roll1 + roll2;
            // and display the total.

            System.out.println("The total is " + sum + "!");


        } while (roll1 != roll2);

    }
}
