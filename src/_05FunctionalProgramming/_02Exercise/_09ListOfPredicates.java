package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntPredicate divisibleFilter = num -> {
            for (int element : numbers) {
                if(num % element != 0) {
                    return false;
                }
            }

            return true;
        };

        System.out.println(IntStream.range(1, n + 1)
                .filter(divisibleFilter)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" ")));

//        for (int number = 1; number <= n; number++) {
//            if(divisibleFilter.test(number)) {
//                System.out.print(number + " ");
//            }
//        }
    }
}
