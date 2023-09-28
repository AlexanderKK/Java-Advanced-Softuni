package _08Generics._01Lab._04ListUtilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        Integer maxInt = ListUtils.getMax(integers);
        System.out.println(maxInt);

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        String minString = ListUtils.getMin(strings);
        System.out.println(minString);

        List<Double> doubles = new ArrayList<>();
        Collections.addAll(doubles, 1.5, 2.5, 3.5);

        double minDouble = ListUtils.getMin(doubles);
        System.out.println(minDouble);

        double maxDouble = ListUtils.getMax(doubles);
        System.out.println(maxDouble);

        List<Boolean> booleans = List.of(true, false, true);
        System.out.println(ListUtils.getMax(booleans));

        booleans.clear();

        System.out.println(booleans);
    }
}
