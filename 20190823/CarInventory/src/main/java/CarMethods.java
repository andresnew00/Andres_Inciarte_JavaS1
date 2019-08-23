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

//    public static String search(){
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("What type of search would you like to do?" +
//                "\n 1 - Make \n 2 - Model " +
//                "\n 3 - Year \n 4 - Color \n 5 - Miles (less than)");
//        int userNum = Integer.parseInt(scanner.nextLine());
//
//        if(userNum == 1){
//            System.out.print("Please enter the make: ");
//            String userMake = scanner.next();
//            return userMake;
//        }else if (userNum == 2){
//            System.out.print("Please enter the model: ");
//            String userModel = scanner.next();
//            return userModel;
//        }else if (userNum == 3){

//            String yearSwitch = Integer.toString(userYear);
//            //we got to turn this into an int and turn it into a string
//            return yearSwitch;
//        } else if (userNum == 4){

//            return userColor;
//        } else if (userNum == 5){

//            String milesSwitch = Integer.toString(userMiles);
//            //we got to turn this into an int and turn it into a string
//            return milesSwitch;
//        } else {
//            System.out.println("You entered a invalid entry.");
//            return null;
//        }

    }
