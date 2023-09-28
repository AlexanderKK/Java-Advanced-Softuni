package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Consumer<String> printer = System.out::println;

        Arrays.stream(input).forEach(printer);
    }
}
