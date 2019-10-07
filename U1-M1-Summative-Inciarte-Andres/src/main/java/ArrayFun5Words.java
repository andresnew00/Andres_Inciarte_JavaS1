import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = 1;
        List<String> words = new ArrayList<>();

        System.out.println("Please provide words for me to read: ");

        while (count <= 5) {
            count++;
            String userString = scanner.nextLine();
            words.add(userString);
        }

        System.out.println("these were the words you provided");
        words.forEach(word -> System.out.println(word));
    }
}

//before refactoring

//        Scanner myScanner = new Scanner(System.in);
//        //Your code must read 5 words from the user,
//        String userInput;
//
//        String[] userWordArray = new String[5];
//        for (int i = 0; i < userWordArray.length; i++) {
//            System.out.println("Please provide a word: ");
//            userInput = myScanner.nextLine();
//
//            //put them in an array,
//            userWordArray[i] = userInput;
//        }
//        // display all the words
//        System.out.println("Array elements: ");
//        for (int i = 0; i < userWordArray.length; i++) {
//            System.out.println(userWordArray[i]);
//        }