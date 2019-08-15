import java.util.Scanner;

public class RightTriangleChecker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int userSide1;
        int userSide2;
        int userSide3;

        System.out.println("Enter three integers:");
        System.out.print("Side 1: ");
        userSide1 = Integer.parseInt(scan.next());

        while (userSide1 <= 0) {

            System.out.println(userSide1 + " is smaller than 0.  Try again.");
            System.out.print("Side 1: ");
            userSide1 = Integer.parseInt(scan.next());

        }

        System.out.print("Side 2: ");
        userSide2 = Integer.parseInt(scan.next());

        while (userSide2 < userSide1) {

            System.out.println(userSide2 + " is smaller than " + userSide1 + " .  Try again.");
            System.out.print("Side 2: ");
            userSide2 = Integer.parseInt(scan.next());

        }

        System.out.print("Side 2: ");
        userSide3 = Integer.parseInt(scan.next());

        while (userSide3 < userSide2) {

            System.out.println(userSide3 + " is smaller than " + userSide2 + " .  Try again.");
            System.out.print("Side 3: ");
            userSide3 = Integer.parseInt(scan.next());

        }

        System.out.println("Your three sides are " + userSide1 + " " + userSide2 + " " + userSide3);

        int side1Sqr = userSide1 * userSide1;
        int side2Sqr = userSide2 * userSide2;
        int side3Sqr = userSide3 * userSide3;

        if (side1Sqr + side2Sqr == side3Sqr) {
            System.out.println("These sides *do* make a right triangle.  Yippy-skippy!");
        } else {
            System.out.println("NO!  These sides do not make a right triangle!");
        }
    }
}
