package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JSONWriteAndRead {
    public static void main(String[] args) {

        PrintWriter writer = null;

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));


        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            System.out.println(jsonCarList);

            writer = new PrintWriter(new FileWriter("Cars.json"));

            writer.println(jsonCarList);


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

        try {
            ObjectMapper mapper = new ObjectMapper();

            List<Car> myCarList;

            myCarList = mapper.readValue(new File("Cars.json"), new TypeReference<List<Car>>(){});

            for (Car myCar : myCarList) {
                System.out.println("================");
                System.out.println(myCar.getMake());
                System.out.println(myCar.getModel());
                System.out.println(myCar.getColor());
                System.out.println(myCar.getYear());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}