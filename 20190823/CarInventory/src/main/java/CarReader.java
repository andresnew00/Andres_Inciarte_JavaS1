import java.util.*;
import java.util.stream.Collectors;

public class CarReader {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Car> carList = new ArrayList<>();

        Car car1 = new Car("Honda", "Civic", 1997, "Green", 200);
        carList.add(car1);
        Car car2 = new Car("Honda", "Accord", 2010, "Brown", 20000);
        carList.add(car2);
        Car car3 = new Car("Toyota", "Corolla", 2001, "Blue", 40);
        carList.add(car3);

        boolean continueCode = true;

        while(continueCode) {

            System.out.println("Please select what you would like to do: " +
                    "\n 1 - add \n 2 - delete " +
                    "\n 3 - search \n 4 - display \n 0 - Exit");
            int userInput = Integer.parseInt(scanner.nextLine());

            // add new car
            if (userInput == 1) {

                Car newCar = CarMethods.addCar();

                carList.add(newCar);
                for (Car car : carList) {
                    System.out.println(car.toString());
                }

                //remove car
            } else if (userInput == 2) {
                String carModelRemove = CarMethods.removeCar();
                Iterator<Car> iterator = carList.iterator();
                while (iterator.hasNext()) {
                    Car mycar = iterator.next();
                    if (mycar.Model.equals(carModelRemove)) {
                        iterator.remove();
                    }
                }

                // search
            } else if (userInput == 3) {

                System.out.println("What type of search would you like to do?" +
                        "\n 1 - Make \n 2 - Model " +
                        "\n 3 - Year \n 4 - Color \n 5 - Miles (less than)");
                int userNum = Integer.parseInt(scanner.nextLine());

                switch (userNum) {
                    case 1:
                        System.out.print("Please enter the make: ");
                        String userMake = scanner.next();
                        carList
                                .stream()
                                .filter(c -> c.getMake().equals(userMake))
                                .forEach(car -> {
                                    System.out.println("===============");
                                    System.out.println("Make: " + car.getMake());
                                    System.out.println("Model: " + car.getModel());
                                    System.out.println("Color: " + car.getColor());
                                    System.out.println("Year: " + car.getYear());
                                    System.out.println("Miles Driven: " + car.getMilesDriven());
                                });
                        break;
                    case 2:
                        System.out.print("Please enter the model: ");
                        String userModel = scanner.next();
                        carList
                                .stream()
                                .filter(car -> car.getModel().equals(userModel))
                                .forEach(car -> {
                                    System.out.println("===============");
                                    System.out.println("Make: " + car.getMake());
                                    System.out.println("Model: " + car.getModel());
                                    System.out.println("Color: " + car.getColor());
                                    System.out.println("Year: " + car.getYear());
                                    System.out.println("Miles Driven: " + car.getMilesDriven());
                                });
                        break;

                    case 3:
                        System.out.print("Please enter the year: ");
                        int userYear = Integer.parseInt(scanner.nextLine());

                        carList
                                .stream()
                                .filter(car -> car.getYear() < userYear)
                                .forEach(car -> {
                                    System.out.println("===============");
                                    System.out.println("Make: " + car.getMake());
                                    System.out.println("Model: " + car.getModel());
                                    System.out.println("Color: " + car.getColor());
                                    System.out.println("Year: " + car.getYear());
                                    System.out.println("Miles Driven: " + car.getMilesDriven());
                                });
                        break;
                    case 4:
                        System.out.print("Please enter the color: ");
                        String userColor = scanner.next();

                        carList
                                .stream()
                                .filter(car -> car.getModel().equals(userColor))
                                .forEach(car -> {
                                    System.out.println("===============");
                                    System.out.println("Make: " + car.getMake());
                                    System.out.println("Model: " + car.getModel());
                                    System.out.println("Color: " + car.getColor());
                                    System.out.println("Year: " + car.getYear());
                                    System.out.println("Miles Driven: " + car.getMilesDriven());
                                });
                        break;
                    case 5:
                        System.out.print("Please enter the miles: ");
                        int userMiles = Integer.parseInt(scanner.nextLine());

                        carList
                                .stream()
                                .filter(car -> car.getYear() < userMiles)
                                .forEach(car -> {
                                    System.out.println("===============");
                                    System.out.println("Make: " + car.getMake());
                                    System.out.println("Model: " + car.getModel());
                                    System.out.println("Color: " + car.getColor());
                                    System.out.println("Year: " + car.getYear());
                                    System.out.println("Miles Driven: " + car.getMilesDriven());
                                });
                        break;

                        default:
                            System.out.println("Please enter a valid number");

                }
                //display
            } else if (userInput == 4) {
                if (carList.isEmpty()) {
                    System.out.println("There are no cars to display");
                } else {
                    CarMethods.display();
                    for (Car car : carList) {
                        System.out.println(car.toString());
                    }
                }
                //not a valid number
            } else if (userInput == 0) {
                continueCode = false;
            } else{
                    System.out.println("Please enter a valid number.");
                }

        }

        System.out.println("Thank you come back soon!");

    }
}
