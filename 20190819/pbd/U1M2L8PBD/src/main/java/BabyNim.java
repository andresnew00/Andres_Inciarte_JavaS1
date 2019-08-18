import java.util.Scanner;

public class BabyNim {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pile1 = 3;
        int pile2 = 3;
        int pile3 = 3;

        int userNumber;

        System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3 + "\n");

        do {

            System.out.println("Choose a pile: ");
            String userLetter = scanner.next().toUpperCase();
            System.out.println("How many to remove from pile " + userLetter + ": " );
            userNumber = scanner.nextInt();


            if(userLetter.equals("A")) {
                pile1 = pile1 - userNumber;
            }
            else if (userLetter.equals("B")){
                pile2 = pile2 - userNumber;
            }
            else if (userLetter.equals("C")){
                pile3 = pile3 - userNumber;
            }

            System.out.println("A: " + pile1 + "\tB: " + pile2 + "\tC: " + pile3 + "\n");

        } while (pile1 > 0 || pile2 > 0 || pile3 > 0);
        System.out.println("All piles are empty. Good job!");
    }
}
