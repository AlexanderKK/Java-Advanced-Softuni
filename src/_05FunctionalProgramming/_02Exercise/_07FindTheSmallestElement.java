package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinIndex = list -> {
            Integer min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int index = 0; index < list.size(); index++) {
                Integer num = list.get(index);

                if (num <= min) {
                    min = num;
                    minIndex = index;
                }
            }

            return minIndex;
        };

        Function<List<Integer>, Integer> findSmallest = elements -> getMinIndex.apply(elements);

        System.out.println(findSmallest.apply(numbers));
    }
}
