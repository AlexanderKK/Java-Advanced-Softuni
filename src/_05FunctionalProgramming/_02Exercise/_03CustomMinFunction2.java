package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03CustomMinFunction2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Function<Integer[], Integer> getMin = elements -> Arrays.stream(elements).min(Comparator.comparingInt(l -> l)).orElse(0);
        Function<Integer[], Integer> getMin2 = elements -> Arrays.stream(elements).min(Integer::compare).orElseThrow(IllegalArgumentException::new);
        Function<Integer[], Integer> getMin3 = elements -> Collections.min(Arrays.stream(elements).collect(Collectors.toList()));
        Function<Integer[], Integer> getMin4 = elements -> Arrays.stream(elements).mapToInt(Integer::new).min().orElseThrow(IllegalArgumentException::new);

        System.out.println(getMin.apply(numbers));
    }
}
