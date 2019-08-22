import java.util.ArrayList;
import java.util.Random;

public class CopyingArrayLists {
    public static void main(String[] args) {

        ArrayList<Integer> oldArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Random rand = new Random();
            int randomNum = rand.nextInt( 100) + 10;

            oldArray.add(randomNum);
        }

        ArrayList<Integer> newArray = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            newArray.add(oldArray.get(i));
        }

        oldArray.set(9, -7);

        System.out.println(" old array: " + oldArray + " new array: " + newArray);
    }
}
