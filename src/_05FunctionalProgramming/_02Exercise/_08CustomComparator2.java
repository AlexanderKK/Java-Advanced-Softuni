package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08CustomComparator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Comparator<Integer> compareNumbers = (first, second) -> {
            if(first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if(first % 2 != 0 && second % 2 == 0) {
                return 1;
            }

            return first.compareTo(second);
        };

        Arrays.sort(numbers, compareNumbers);
//        Arrays.stream(numbers).collect(Collectors.toList()).sort(compareNumbers);

        System.out.println(Arrays.stream(numbers)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
