import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rootNum;
        double sqrRoot;

        System.out.println("SQUARE ROOT!");
        System.out.print("Enter a number: ");
        rootNum = Integer.parseInt(scan.next());


        if(rootNum < 0) {
            System.out.println("You can't take the square root of a negative number, silly.");
            System.out.print("Try again: ");
            rootNum = Integer.parseInt(scan.next());
        }

        while (rootNum > 0) {


            sqrRoot = Math.sqrt(rootNum);

            System.out.println("The square root of " + rootNum + " is " + sqrRoot);
            break;

        }


    }
}
