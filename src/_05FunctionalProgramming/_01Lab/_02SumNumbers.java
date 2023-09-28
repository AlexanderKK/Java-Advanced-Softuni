package _05FunctionalProgramming._01Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        //Declare function
        Function<int[], String> count = elements -> "Count = " + Arrays.stream(elements).count();
        Function<int[], String> sum = elements -> "Sum = " + Arrays.stream(elements).sum();

        //Apply the function
        System.out.println(count.apply(numbers));
        System.out.println(sum.apply(numbers));
    }
}
