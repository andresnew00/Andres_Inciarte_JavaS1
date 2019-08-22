import java.util.ArrayList;
import java.util.Random;

public class BasicArrayList3 {
    public static void main(String[] args) {

        ArrayList<Integer> arrList = new ArrayList<>();

        for(int i = 0 ; i < 1000; i++){
            Random rand = new Random();
            int randomNum = rand.nextInt( 100) + 10;
            arrList.add(randomNum);
        }

        System.out.println("ArrayList: " + arrList);
    }
}
