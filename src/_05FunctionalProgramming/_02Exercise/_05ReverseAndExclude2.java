package _05FunctionalProgramming._02Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05ReverseAndExclude2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        Predicate<Integer> isNotDivisible = e -> e % n != 0;

        System.out.println(numbers
                .stream()
                .filter(isNotDivisible)
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
