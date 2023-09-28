package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class _04AppliedArithmetic {
    public static List<Integer> numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> addValue = elements -> elements.stream().map(e -> e + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractValue = elements -> elements.stream().map(e -> e - 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyValue = elements -> elements.stream().map(e -> e * 2).collect(Collectors.toList());

        Function<String, List<Integer>> operation = cmd -> {
            if (cmd.equals("add")) {
                numbers = addValue.apply(numbers);
            } else if (cmd.equals("subtract")) {
                numbers = subtractValue.apply(numbers);
            } else if (cmd.equals("multiply")) {
                numbers = multiplyValue.apply(numbers);
            }
            return numbers;
        };

        Consumer<List<Integer>> printer = numbers -> System.out.println(
                 numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "))
        );

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            if (command.equals("print")) {
                printer.accept(numbers);
            } else {
                operation.apply(command);
            }
        }
    }
}
