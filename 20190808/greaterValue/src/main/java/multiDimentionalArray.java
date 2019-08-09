import java.util.Scanner;

public class multiDimentionalArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] numbers = new int[10];
//
//        String stringIn;
//
//        int min;
//        int max;
//        int sum = 0;
//        double avg;
//
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println("Please enter a number: ");
//            stringIn = scanner.nextLine();
//            numbers[i] = Integer.parseInt(stringIn);
//        }
//
//        // calculate max
//
//        max = numbers[0];
//
//        for(int i = 0; i < numbers.length; i++) {
//            if(numbers[i] > max) {
//                max = numbers[i];
//            }
//        }
//
//        //calculate min
//
//        min = numbers[0];
//        for(int i = 0; i < numbers.length; i++) {
//            if(numbers[i] < min) {
//                min = numbers[i];
//            }
//        }
//
//        //calculate average
//
//        for(int i = 0; i < numbers.length; i++) {
//            sum += numbers[i];
//        }
//
//        avg = sum/(double)numbers.length;
//
//        System.out.println("Average is " + avg );
//
//        System.out.println("Minimum value is: " + min);
//        System.out.println("Maximum value is: " + max);
//        System.out.println("Sum: " + sum);
//
//
//        String[] [] multiArr = {
//                {"a" , "b" , "c"},
//                {"1" , "2" , "3"},
//                {"i" , "ii" , "iii"}
//        };
//
//        for(int i = 0; i < multiArr.length; i++) {
//            for(int j = 0; j < multiArr[i].length; j++){
//                System.out.println(multiArr[i][j]);
//            }
//    }
        int[] arrInt = new int[4];
        arrInt[0] = 10;
        arrInt[1] = 20;
        arrInt[2] = 30;
        arrInt[3] = 40;
        for (int element : arrInt) {
            System.out.println("Assign a value " + element);
        }
    }
}

