import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GettingtheLargestValue {
    public static void main(String[] args) {
        ArrayList<Integer> intArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int number = rand.nextInt(100) + 1;

            intArray.add(number);

        }

        System.out.println("ArrayList: " + intArray);

        Object objInt = Collections.max(intArray);
        System.out.println("The largest value is " + objInt);
    }
}
