package FunctionPackage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by jack on 12/4/16.
 */

public class functional {

    private static String getName(String s){
        return s.split("[|]")[0];
    }

    private static String getProducer(String s){
        return s.split("[|]")[1];
    }


    private static String getRevenue(String s) {
        return s.split("[|]")[2]; // split will split a string into an array of
        // strings based on given regular expression
    }

    private static String getYear(String s){
        return s.split("[|]")[3];
    }



    public static void main(String[] args) {
        Path path = Paths.get("/Users/jack/IdeaProjects/functional/src/Movie-Data.txt");
        try {

            /*
            // Part 1
            String max = Files.lines(path)
                    .max((line1, line2) -> Double.valueOf(getRevenue(line1)).compareTo(Double.valueOf(getRevenue(line2))))
                        .get();
            System.out.println(max);

            // Part 2

            double seventies = Files.lines(path).filter((line) -> Integer.parseInt(getYear(line)) >= 1970)
                    .filter((line) -> Integer.parseInt(getYear(line)) < 1980)
                    .mapToDouble((line) -> Double.valueOf(getRevenue(line)))
                    .sum();

            double sixties = Files.lines(path).parallel().filter((line) -> Integer.parseInt(getYear(line)) >= 1960)
                                        .filter((line) -> Integer.parseInt(getYear(line)) < 1970)
                                        .mapToDouble((line) -> Double.valueOf(getRevenue(line)))
                                        .sum();

            System.out.println("Studios made " + sixties + "M in the sixties and");
            System.out.println("made " + seventies + "M in the seventies");

            if (sixties > seventies){
                System.out.println("Therefore, sixties win.");
            }
            else{
                System.out.println("Therefore, seventies win.");
            }

            // Part 3

            Files.lines(path)
                            .filter((line) -> Double.valueOf(getRevenue(line)) > 500.00)
                                .forEach((line) -> System.out.println(line));


            */
            // Part 4

            Files.lines(path).filter((line) -> Integer.parseInt(getYear(line)) >= 1960)
                    .filter((line) -> Integer.parseInt(getYear(line)) < 1970)
                    .collect((line) -> Collectors.groupingBy(getProducer(line)));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

