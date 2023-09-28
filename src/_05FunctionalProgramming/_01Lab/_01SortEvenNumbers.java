package _05FunctionalProgramming._01Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
//                .map(Integer::parseInt)
//                .filter(n -> n % 2 == 0)
//                .collect(Collectors.toList());
//
//        System.out.println(
//                 numbers.stream()
//                .map(String::valueOf)
//                .collect(Collectors.joining(", "))
//        );
//
//        System.out.println(
//                 numbers.stream()
//                .sorted()
//                .map(String::valueOf)
//                .collect(Collectors.joining(", ")));
        String input = scanner.nextLine();

        System.out.println(Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(input.split(", "))
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
