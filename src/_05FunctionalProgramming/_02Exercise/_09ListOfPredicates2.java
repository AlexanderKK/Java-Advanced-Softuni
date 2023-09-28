package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09ListOfPredicates2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        BiPredicate<Set<Integer>, Integer> checkForDivisibleNumber = (elements, num) -> {
            for (Integer element : elements) {
                if(num % element != 0) {
                    return false;
                }
            }
            return true;
        };

        IntPredicate isDivisible = el -> checkForDivisibleNumber.test(numbers, el);

        System.out.println(IntStream.range(1, n + 1)
                .filter(isDivisible)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
