package _03SetsAndMaps._02Exercise;

import java.util.HashMap;
import java.util.Map;

public class _00SortMapWays {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>() {{put("Peter", 4); put("Tomas", 5); put("Lexus", 3); put("Mike", 5);}};

        //Get average from map values
        map.values().stream().mapToInt(e -> e).average();

        //Sort map by values in ascending order
        System.out.println("\nSort map by values in ascending order");
        map.entrySet().stream().sorted(
            (left, right) -> {
                return left.getValue() - right.getValue();
            }
        ).forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));


        //Sort map by values in descending order
        System.out.println("\nSort map by values in descending order");
        map.entrySet().stream().sorted(
            (left, right) -> {
                return right.getValue() - left.getValue();
            }
        ).forEach((entry) -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));

        //Sort map by keys in ascending order
        System.out.println("\nSort map by keys in ascending order");
        map.entrySet().stream().sorted(
                (left, right) -> {
                    return left.getKey().compareTo(right.getKey());
                }
        ).forEach((entry) -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));

        //Sort map by keys in descending order
        System.out.println("\nSort map by keys in descending order");
        map.entrySet().stream().sorted(
                (left, right) -> {
                    return right.getKey().compareTo(left.getKey());
                }
        ).forEach((entry) -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));

        //Sort map by values in ascending order and if values are equal sort those entries by keys in ascending order
        System.out.println("\nSort map by values in ascending order and if values are equal sort those entries by keys in ascending order");
        map.entrySet().stream().sorted(
                (left, right) -> {
                    int diff = left.getValue() - right.getValue();
                    if(diff == 0) {
                        return left.getKey().compareTo(right.getKey());
                    }
                    return diff;
                }
        ).forEach((entry) -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
