import java.util.Random;
import java.util.Scanner;

public class dice {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        // variable containing first seven loop and the total amount of sevens in loop
        int firstSeven = 0;
        int totalSevens = 0;

        for (int i = 1; i < 101; i++) {
            // creating 2 dices and adding them to get 7
            int dice1 = randomGenerator.nextInt(6) + 1;
            int dice2 = randomGenerator.nextInt(6) + 1;
            int diceSum = dice1 + dice2;

            // conditionals check
            if (diceSum == 7 && firstSeven == 0) {
                //once first seven goes up it does not changes anymore after looping
                firstSeven++;
                totalSevens++;

                int firstNumberSeven = i;
                System.out.println("tries before first seven: " + firstNumberSeven);

            } else if (diceSum == 7) {
                totalSevens++;
            }
        }
        System.out.println("Total of times loop hit 7: " + totalSevens);

        //BONUS

        System.out.println("How many times would you like to roll a dice?");
        int userChoice = Integer.parseInt(myScanner.nextLine());

        for (int y = 1; y < (userChoice + 1); y++) {
            int userDice1 = randomGenerator.nextInt(6) + 1;
            int userDice2 = randomGenerator.nextInt(6) + 1;
            int diceSum2 = userDice1 + userDice2;

            System.out.println(diceSum2);

        }


    }

}
