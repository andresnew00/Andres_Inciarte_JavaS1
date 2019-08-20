import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class City {
    String city;
    int population;

    //this is a constructor
    public City(String city, int population) {
        this.city = city;
        this.population = population;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //instantiation of an object
        City newYork = new City("New York", 8654321);
        City LA = new City("Los Angeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> largestCities = new HashMap<>();

        largestCities.put("New York", newYork);
        largestCities.put("California", LA);
        largestCities.put("Illinois", chicago);
        largestCities.put("Colorado", denver);
        largestCities.put("Iowa", desMoines);
        largestCities.put("Georgia", atlanta);

        System.out.println("Please enter a population to look for the State and City: ");
        int userPopulation = Integer.parseInt(scanner.nextLine());



        Set<String> myKeys = largestCities.keySet();
        for (String key : myKeys) {
            City newcity = largestCities.get(key);
            System.out.println("State: " + key + ", Major City: " + newcity.city
                    + ", Population: " + newcity.population);
        }
    }

}
