import java.util.Scanner;

public class MonthConverterIf {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        String userInput;
        int userInt;

        System.out.println("Please enter a number between 1 and 12");
        userInput = myScanner.nextLine();
        userInt = Integer.parseInt(userInput);


        if (userInt == 1) {
            System.out.println("January");
        } else if (userInt == 2) {
            System.out.println("February");
        } else if (userInt == 3) {
            System.out.println("March");
        } else if (userInt == 4) {
            System.out.println("April");
        } else if (userInt == 5) {
            System.out.println("May");
        } else if (userInt == 6) {
            System.out.println("June");
        } else if (userInt == 7) {
            System.out.println("July");
        } else if (userInt == 8) {
            System.out.println("August");
        } else if (userInt == 9) {
            System.out.println("September");
        } else if (userInt == 10) {
            System.out.println("October");
        } else if (userInt == 11) {
            System.out.println("November");
        } else if (userInt == 12) {
            System.out.println("December");
        } else {
            System.out.println("You have entered an invalid number. You must enter a number between 1 and 12. Goodbye.");
        }
    }
}
