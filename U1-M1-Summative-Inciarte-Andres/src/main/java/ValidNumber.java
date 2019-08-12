import java.util.Scanner;

public class ValidNumber {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int userInt;

        System.out.println("Please enter a number between 1 and 10");
        userInput = myScanner.nextLine();
        userInt = Integer.parseInt(userInput);

        while (userInt > 10 || userInt < 1) {

            System.out.println("You must enter a number between 1 and 10, please try again.");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);

        }

        System.out.println(userInt);

    }
}
