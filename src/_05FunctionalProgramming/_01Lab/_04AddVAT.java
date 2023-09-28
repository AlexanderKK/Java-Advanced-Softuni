package _05FunctionalProgramming._01Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class _04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        DoubleUnaryOperator addVAT = element -> element * 1.20;

        Consumer<double[]> printPrices = p -> {
            System.out.println("Prices with VAT:");

//            Arrays.stream(prices)
//                    .forEach(p -> System.out.printf("%.2f%n", addVAT.applyAsDouble(p)));

            System.out.println(Arrays.stream(p)
                    .map(addVAT)
                    .mapToObj(e -> String.format("%.2f", e))
                    .collect(Collectors.joining(System.lineSeparator())));
        };

        printPrices.accept(prices);
    }
}
