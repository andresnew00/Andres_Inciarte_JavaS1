package com.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class XMLWriteAndRead {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        PrintWriter writer = null;
        // Write
        try {
            ObjectMapper mapper = new XmlMapper();
            String jsonCarList = mapper.writeValueAsString(carList);

            System.out.println(jsonCarList);


            writer = new PrintWriter(new FileWriter("Cars.xml"));

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
        // Read

        try {
            ObjectMapper mapper = new XmlMapper();

            List<Car> myCarList;

            myCarList = mapper.readValue(new File("Cars.xml"), new TypeReference<List<Car>>(){});

            for (Car car : myCarList) {
                System.out.println("================");
                System.out.println(car.getMake());
                System.out.println(car.getModel());
                System.out.println(car.getYear());
                System.out.println(car.getColor());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }
}
