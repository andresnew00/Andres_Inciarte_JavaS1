import java.util.*;
import java.util.stream.Collectors;

public class CarReader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        Car car1 = new Car("Honda", "Civic", 1997, "Green", 200);
//        CarMethods.carList.add(car1);
//        Car car2 = new Car("Honda", "Accord", 2010, "Brown", 20000);
//        CarMethods.carList.add(car2);
//        Car car3 = new Car("Toyota", "Corolla", 2001, "Blue", 40);
//        CarMethods.carList.add(car3);

//        CarMethods.writeDocument();

        boolean continueCode = true;

        int userInput;

        while (continueCode) {

            System.out.println("Please select what you would like to do: " +
                    "\n 1 - add \n 2 - delete " +
                    "\n 3 - search \n 4 - display \n 0 - Exit");
            userInput = Integer.parseInt(scanner.next());

            // add new car
            if (userInput == 1) {

                CarMethods.addCar();

                //remove car
            } else if (userInput == 2) {

                CarMethods.removeCar();

                // search
            } else if (userInput == 3) {

                CarMethods.searchBy();

                //display
            } else if (userInput == 4) {

                CarMethods.display();

                //not a valid number
            } else if (userInput == 0) {

                continueCode = false;

            } else {

                System.out.println("Please enter a valid number.");

            }

        }

        System.out.println("Thank you come back soon!");

    }
}
