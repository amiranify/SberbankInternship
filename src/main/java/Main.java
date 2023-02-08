import java.util.List;

public class Main {
    public static void main(String... args) {
        CityUtils cityUtils = new CityUtils();
        List<City> cities = cityUtils.parse();
        print(cities);
    }

    public static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }
}
