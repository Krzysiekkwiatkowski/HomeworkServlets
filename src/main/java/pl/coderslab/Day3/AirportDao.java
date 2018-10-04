package pl.coderslab.Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

public class AirportDao {

    List<Airport> getList(){
        ArrayList<Airport> airports = new ArrayList<>();
        File file = new File("/home/oem/Coderslab/HomeworkServlets/airports.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine(), ",");
                String name = stringTokenizer.nextToken();
                int code = Integer.parseInt(stringTokenizer.nextToken());
                LocalDateTime timezone = LocalDateTime.parse(stringTokenizer.nextToken());
                Airport airport = new Airport(name, code, timezone);
                airports.add(airport);
            }
            return airports;
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
