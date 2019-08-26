import java.util.Scanner;

public class CarMethods{

    public static Car addCar(){
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

        Car anotherCar = new Car(userCarMake,userModel,userYear,userColor,userMiles);

        return anotherCar;

    }

    public static String removeCar(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the model of the car you would like to delete: ");
        String userDelete = scanner.next();

        return userDelete;

    }

    public static void display(){
        System.out.println("Displaying all cars in list: ");
    }

    }

    public static void
