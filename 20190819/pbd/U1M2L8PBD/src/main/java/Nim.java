import java.util.Scanner;

public class Nim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pile1 = 3;
        int pile2 = 4;
        int pile3 = 5;

        int playerCounter = 1;
        String player;
        String playerOne = "";
        String playerTwo = "";


        int userNumber;

        System.out.print("Player 1, enter your name: ");
        playerOne = scanner.next();

        System.out.print("Player 2, enter your name: ");
        playerTwo = scanner.next();

        System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3 + "\n");

        do {

            if ((playerCounter % 2) == 0) {
                player = playerTwo;
            } else {
                player = playerOne;
            }

            System.out.print(player + ", Choose a pile: ");
            String userLetter = scanner.next().toUpperCase();
            System.out.print("How many to remove from pile " + userLetter + ": ");
            userNumber = scanner.nextInt();


            switch (userLetter) {
                case "A":
                    pile1 = pile1 - userNumber;
                    break;
                case "B":
                    pile2 = pile2 - userNumber;
                    break;
                case "C":
                    pile3 = pile3 - userNumber;
                    break;
                default:
                    System.out.println("Please, enter a valid Character (A B or C)");
            }

            System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3 + "\n");

            playerCounter++;


        } while (pile1 > 0 || pile2 > 0 || pile3 > 0);

        if ((playerCounter % 2) == 0) {
            player = playerTwo;
        } else {
            player = playerOne;
        }

        System.out.println(player + ", there are no counters left, so you WIN!");
    }


}
