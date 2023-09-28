package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> wordFilter = w -> w.length() <= n;

        Arrays.stream(words)
                .filter(wordFilter)
                .forEach(System.out::println);
    }
}
