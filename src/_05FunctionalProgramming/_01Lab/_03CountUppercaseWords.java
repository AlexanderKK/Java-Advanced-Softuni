package _05FunctionalProgramming._01Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Predicate<String> isCapitalized = word -> Character.isUpperCase(word.charAt(0));

        //Filter capitalized words and get their count
        System.out.println(Arrays.stream(input)
                .filter(isCapitalized)
                .count());

        //Filter capitalized words and print them
        Arrays.stream(input)
                .filter(isCapitalized)
                .forEach(System.out::println);
    }
}
