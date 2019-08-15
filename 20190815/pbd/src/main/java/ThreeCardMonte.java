import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        Random randomGenerator = new Random();

        System.out.println("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n" +
                "\n" +
                "Which one is the ace?\n" +
                "\n" +
                "\t##  ##  ##\n" +
                "\t##  ##  ##\n" +
                "\t1   2   3\n");

        int userInput = Integer.parseInt(myScanner.nextLine());

        int randomNumber = randomGenerator.nextInt(3) + 1;

        // 1

        if (userInput == 1 && randomNumber == 3) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.\n" +
                    "\n" +
                    "\t##  ##  AA\n" +
                    "\t##  ##  AA\n" +
                    "\t1   2   3");

        } else if (userInput == 1 && randomNumber == 2) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 2.\n" +
                    "\n" +
                    "\t##  AA  ##\n" +
                    "\t##  AA  ##\n" +
                    "\t1   2   3");

        } else if (userInput == 1 && randomNumber == 1) {

            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                    "\n" +
                    "\tAA  ##  ##\n" +
                    "\tAA  ##  ##\n" +
                    "\t1   2   3");

        }

        // 2

        else if (userInput == 2 && randomNumber == 3) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 3.\n" +
                    "\n" +
                    "\t##  ##  AA\n" +
                    "\t##  ##  AA\n" +
                    "\t1   2   3");

        } else if (userInput == 2 && randomNumber == 2) {

            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                    "\n" +
                    "\t##  AA  ##\n" +
                    "\t##  AA  ##\n" +
                    "\t1   2   3");

        } else if (userInput == 2 && randomNumber == 1) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 1.\n" +
                    "\n" +
                    "\tAA  ##  ##\n" +
                    "\tAA  ##  ##\n" +
                    "\t1   2   3");

        }
        // 3

        else if (userInput == 3 && randomNumber == 3) {

            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n" +
                    "\n" +
                    "\t##  ##  AA\n" +
                    "\t##  ##  AA\n" +
                    "\t1   2   3");

        } else if (userInput == 3 && randomNumber == 2) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 2.\n" +
                    "\n" +
                    "\t##  AA  ##\n" +
                    "\t##  AA  ##\n" +
                    "\t1   2   3");

        } else if (userInput == 3 && randomNumber == 1) {

            System.out.println("Ha! Fast Eddie wins again! The ace was card number 1.\n" +
                    "\n" +
                    "\tAA  ##  ##\n" +
                    "\tAA  ##  ##\n" +
                    "\t1   2   3");

        }


    }


}
