package com.company;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWriteAndRead {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car(2012, "Toyota", "Camry", "Blue"));
        carList.add(new Car(2001, "Honda", "Civic", "Silver"));
        carList.add(new Car(2009, "Jeep", "Wrangler", "Rust"));
        carList.add(new Car(2018, "Tesla", "Roadster", "Black"));
        carList.add(new Car(1964, "Ford", "Mustang", "Red"));

        try {
            Writer writer = new FileWriter("Cars.csv");
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(carList);
            writer.close();

            List<Car> myCars = new CsvToBeanBuilder<Car>(new FileReader("Cars.csv"))
                    .withType(Car.class).build().parse();

            for (Car myCar : myCars) {
                System.out.println("=================================");
                System.out.println(myCar.getMake());
                System.out.println(myCar.getModel());
                System.out.println(myCar.getYear());
                System.out.println(myCar.getColor());


            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            System.out.println("ERROR: Something went wrong writing your CSV file: " + e.getMessage());
        }
    }
}
