import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String... args) {
        CityUtils cityUtils = new CityUtils();
        List<City> cities = cityUtils.parse();

        /**
         * Поиск города с наибольшим количеством жителей
         */

        City[] array = cities.toArray(new City[0]);
        int max = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPopulation() > max) {
                max = array[i].getPopulation();
                index = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", index, max));
        System.out.println();

        /**
         * Сортировка списка городов по наименованию
         * в алфавитном порядке по убыванию без учета регистра;
         * вариант реализации Comparator
         */
        cities.sort(Comparator.comparing(City::getName));
        cities.forEach(System.out::println);
        System.out.println();

        /**
         * Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального
         * округа в алфавитном порядке по убыванию с учетом регистра;
         * вариант реализации Comparator
         */

        cities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        cities.forEach(System.out::println);
        System.out.println();

        /**
         * Сортировка списка городов по наименованию
         * в алфавитном порядке по убыванию без учета регистра;
         * вариант реализации lambda-выражения
         */

        cities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        cities.forEach(System.out::println);
        System.out.println();

    }
}