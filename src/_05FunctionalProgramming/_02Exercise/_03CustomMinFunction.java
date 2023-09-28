package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

//        Function<List<Integer>, Integer> minNumber = elements -> elements.stream()
//                .min(Integer::compare)
//                .orElse(0);

//        Function<int[], Integer> minNumber = elements -> Arrays.stream(elements)
//                .min().orElseThrow(IllegalArgumentException::new);

        Function<int[], Integer> minNumber = elements -> Collections.min(Arrays.stream(elements).boxed().collect(Collectors.toList()));

        System.out.println(minNumber.apply(numbers));
    }
}
