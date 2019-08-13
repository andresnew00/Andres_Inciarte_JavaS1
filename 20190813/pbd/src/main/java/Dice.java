import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        Random randomGenerator = new Random();

        System.out.println("HERE COMES THE DICE!");
        //Write a program that simulates a dice roll by picking a random number from 1-6
            int roll1 = randomGenerator.nextInt(6) + 1;
            System.out.println("Roll #1: " + roll1);

        // and then picking a second random number from 1-6. Add the two values together,
        int roll2 = randomGenerator.nextInt(6) + 1;
        System.out.println("Roll #2: " + roll2);

        //sum
        int sum = roll1 + roll2;
        // and display the total.
        System.out.println("The total is " + sum + "!");
    }
}
