import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ArrayListThereorNot {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int number = rand.nextInt(50) + 1;

            intArray.add(number);
        }
        System.out.println("ArrayList: " + intArray);
        System.out.print("Value to find: ");
        int userInt = Integer.parseInt(scan.next());

        boolean torf = intArray.contains(userInt);
            if (torf) {
                System.out.println(userInt + " is in the ArrayList.");
            } else {
                System.out.println(userInt + " is not in the ArrayList.");
            }
    }

}
