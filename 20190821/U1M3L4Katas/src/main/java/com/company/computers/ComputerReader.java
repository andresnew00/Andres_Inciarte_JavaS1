package com.company.computers;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.util.List;

public class ComputerReader {

    public static void main(String[] args) {

        try {
            List<Computer> pcSpecs =
                    new CsvToBeanBuilder<Computer>(new FileReader("computers.csv")).withType(Computer.class).build().parse();

            for (Computer pcs : pcSpecs) {
                System.out.println("=================================");
                System.out.println(pcs.getBrand());
                System.out.println(pcs.getModel());
                System.out.println(pcs.getCPU());
                System.out.println(pcs.getRAM());
                System.out.println(pcs.getStorageSize());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());

        }
    }
}
