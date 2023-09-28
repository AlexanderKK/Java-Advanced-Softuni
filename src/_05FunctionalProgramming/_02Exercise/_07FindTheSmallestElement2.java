package _05FunctionalProgramming._02Exercise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07FindTheSmallestElement2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findMinNumIndex = elements -> {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < elements.size(); i++) {
                int currentNumber = elements.get(i);

                if(currentNumber <= min) {
                    min = currentNumber;
                    minIndex = i;
                }
            }

            return minIndex;
        };

        System.out.println(findMinNumIndex.apply(numbers));
    }
}
