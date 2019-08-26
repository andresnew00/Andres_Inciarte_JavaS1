import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CarMethods {
    public static Scanner scanner = new Scanner(System.in);

    //array list of cars
    public static ArrayList<Car> carList = new ArrayList<>();

    //method that returns a car object detailed by the user
    public static void addCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the Make of the car you are adding: ");
        String userCarMake = scanner.next();

        System.out.print("Please enter the Model of the car you want to add: ");
        String userModel = scanner.next();

        System.out.print("Please enter the car Year: ");
        int userYear = Integer.parseInt(scanner.next());

        System.out.print("Please enter the color of the car you are adding: ");
        String userColor = scanner.next();

        System.out.print("How many miles does the car have? ");
        int userMiles = Integer.parseInt(scanner.next());

        carList.add(new Car(userCarMake, userModel, userYear, userColor, userMiles));
//        for (Car car : carList) {
//            System.out.println(car.toString());
//        }

        PrintWriter writer = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarsList = mapper.writeValueAsString(carList);


            writer = new PrintWriter(new FileWriter("cars.json"));

            writer.println(jsonCarsList);


        } catch (JsonProcessingException e) {
            System.out.println("ERROR: Trouble converting object to JSON string: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR: Could not write to file: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }

    }

    //Method that returns the car that the user is wanting to remove
    public static void removeCar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the model of the car you would like to delete: ");
        String userDelete = scanner.next();

        Iterator<Car> iterator = carList.iterator();
        while (iterator.hasNext()) {
            Car mycar = iterator.next();
            if (mycar.Model.equals(userDelete)) {
                iterator.remove();
            }
        }

    }

    //this method only displays a message when displaying the list
    public static void display() {
        if (carList.isEmpty()) {
            System.out.println("There are no cars to display");
        } else {
            System.out.println("Displaying all cars in list: ");
            for (Car car : carList) {
                System.out.println(car.toString());
            }
        }

    }

    //switch statement and user interaction for searching a car in the list
    public static void searchBy() {
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
                break;

        }
    }

    public static void writeDocument() {


    }
}

