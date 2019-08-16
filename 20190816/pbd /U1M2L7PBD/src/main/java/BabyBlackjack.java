import java.util.Random;

public class BabyBlackjack {
    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Baby Blackjack!");

        int valuePlayer1 = random.nextInt(10 - 1 + 1) + 1;
        int valuePlayer2 = random.nextInt(10 - 1 + 1) + 1;

        int sumPlayer = valuePlayer1 + valuePlayer2;

        System.out.println("You drew " + valuePlayer1 + " and " + valuePlayer2 + ".");
        System.out.println("Your total is " + sumPlayer + ".");

        int valueDealer1 = random.nextInt(10 - 1 + 1) + 1;
        int valueDealer2 = random.nextInt(10 - 1 + 1) + 1;

        int sumDealer = valueDealer1 + valueDealer2;

        System.out.println("The dealer has " + valueDealer1 + " and " + valueDealer2 + ".");
        System.out.println("Dealer's total is " + sumDealer + ".");


        if (sumPlayer > sumDealer) {
            System.out.println("YOU WIN!");
        } else {
            System.out.println("YOU LOSE!");
        }


    }
}
