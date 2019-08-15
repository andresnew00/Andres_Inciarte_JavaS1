import java.util.Scanner;

public class AddingValuesinaLoop {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("I will add up the numbers you give me.");

        int firstNumber;
        int newNumber;
        int sum;

        System.out.print("Number : ");
        firstNumber = Integer.parseInt(scan.next());
        System.out.println("The total so far is " + firstNumber);
        do {
            System.out.print("Number : ");
            newNumber = Integer.parseInt(scan.next());

            sum = firstNumber + newNumber;

            System.out.println("The total so far is " + sum);

            firstNumber = sum;


        } while (newNumber != 0);
    }

}
