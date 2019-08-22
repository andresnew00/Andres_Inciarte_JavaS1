import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FindingaValueinanArrayList {
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

        for (int i = 0; i < intArray.size(); i++) {
            if (userInt == intArray.get(i)) {
                System.out.println(userInt + " is in the ArrayList.");
            }
        }

    }
}
