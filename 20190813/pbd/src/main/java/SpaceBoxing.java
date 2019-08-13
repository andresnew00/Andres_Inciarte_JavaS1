import java.util.Scanner;

public class SpaceBoxing {


    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        double planetsGravity = 0.00;
        //    It should ask him what his earth weight is
        System.out.println("What is your earth weight?");
        double userInput = Double.parseDouble(myScanner.nextLine());
        //, and to enter a number for the planet he wants to fight on.
        System.out.println("I have information for the following planets Choose one to calculate weight:\n" +
                "   1. Venus   2. Mars    3. Jupiter\n" +
                "   4. Saturn  5. Uranus  6. Neptune");
        int planet = Integer.parseInt(myScanner.nextLine());


        switch (planet) {
            case 1:
                planetsGravity = 0.78;
                break;
            case 2:
                planetsGravity = 0.39;
                break;
            case 3:
                planetsGravity = 2.65;
                break;
            case 4:
                planetsGravity = 1.17;
                break;
            case 5:
                planetsGravity = 1.05;
                break;
            case 6:
                planetsGravity = 1.23;
            default:
                System.out.println("Please enter a valid number for the planet");

        }

        double weight = userInput * planetsGravity;

        System.out.println("Your weight would be " + weight + " pounds on that planet.");

    }
}
