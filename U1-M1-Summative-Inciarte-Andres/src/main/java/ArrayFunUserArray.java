import java.util.Scanner;

public class ArrayFunUserArray {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
//        Your code must read 5 ints from the user,
        String userInput;
        int userInt;

        int[] userArray = new int[5];
        for (int i = 0; i < userArray.length; i++) {
            System.out.println("Please provide a number: ");
            userInput = myScanner.nextLine();
            userInt = Integer.parseInt(userInput);
//        put them in an array,
            userArray[i] = userInt;
        }
//        and print the array elements to the screen.
        System.out.println("Array elements: ");
        for (int i = 0; i < userArray.length; i++) {
            System.out.println(userArray[i]);
        }
    }
}
