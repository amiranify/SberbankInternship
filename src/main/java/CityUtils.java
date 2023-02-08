import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {
    /**
     * Загрузка данных о городах в массив
     */
    public static List<City> parse() {
        List<City> cities = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("cities.csv"));
            while (scanner.hasNextLine()) {
                cities.add(parse(scanner.nextLine()));
            }
            scanner.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return cities;
    }

    /**
     * Разбор строки с данными о городе
     */

    private static City parse(String line) {
        Scanner scanner = new Scanner(line);
        String[] values = scanner.nextLine().split(";", 6);
        if (values[5].isEmpty()) {
            values[5] = null;
        }
        scanner.close();

        return new City(values[1], values[2], values[3], Integer.parseInt(values[4]), values[5]);

    }
}