package com.company.Phones;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PhoneReader {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new XmlMapper();

            List<Phone> celList;

            celList = mapper.readValue(new File("phones.xml"), new TypeReference<List<Phone>>(){});

            for (Phone cel : celList) {
                System.out.println("================");
                System.out.println(cel.getBrand());
                System.out.println(cel.getModel());
                System.out.println(cel.getPrice());
                System.out.println(cel.getProcessor());
                System.out.println(cel.getStorage());
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }

    }

}
