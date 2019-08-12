import java.util.Scanner;

public class ArrayFun5Words {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        //Your code must read 5 words from the user,
        String userInput;

        String[] userWordArray = new String[5];
        for (int i = 0; i < userWordArray.length; i++) {
            System.out.println("Please provide a word: ");
            userInput = myScanner.nextLine();

            //put them in an array,
            userWordArray[i] = userInput;
        }
        // display all the words
        System.out.println("Array elements: ");
        for (int i = 0; i < userWordArray.length; i++) {
            System.out.println(userWordArray[i]);
        }
    }
}
