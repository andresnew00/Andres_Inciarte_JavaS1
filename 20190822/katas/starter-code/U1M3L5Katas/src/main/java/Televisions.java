import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Televisions {
    public static void main(String[] args) {
        try{
            ObjectMapper mapper = new ObjectMapper();

            List<TV> tvList;

            tvList = mapper.readValue(new File("televisions.json"), new TypeReference<List<TV>>(){});

            int size = 60;
            System.out.println("All " + size + "+ inches TV in inventory: ");

            //name of arrayList
            tvList
                    .stream()
                    .filter(s -> s.getScreenSize() == (size))
                    .forEach(tvs -> {
                        System.out.println("===============");
                        System.out.println("Make: " + tvs.getScreenSize());
                        System.out.println("Model: " + tvs.getModel());
                        System.out.println("Color: " + tvs.getBrand());
                        System.out.println("Year: " + tvs.getPrice());
                    });

            Map<String, List<TV>> groupedTvs =
                    tvList
                            .stream()
                            .collect(Collectors.groupingBy(s -> s.getBrand()));

            Set<String> keys = groupedTvs.keySet();
            for(String key : keys) {
                //this will print out the keys (brands)
                System.out.println(key);
            }

            double avgScreenSize =
                    tvList
                            .stream()
                            .mapToInt(s -> s.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("=======================");
            System.out.println("Average screen size is: " + avgScreenSize);

            int largestScreen =
                    tvList
                            .stream()
                            .mapToInt(s -> s.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("=======================");
            System.out.println("Largest screen size : " + largestScreen);

        } catch (IOException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }


        }
    }
