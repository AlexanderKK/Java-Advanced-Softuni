package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01ConsumerPrint2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

//        Consumer<String []> printStrings = elements -> {
//            for (String element : elements) {
//                System.out.println(element);
//            }
//        };

//        printStrings.accept(inputArr);


        Consumer<String> printString = System.out::println;
        Arrays.stream(inputArr).forEach(printString);
    }
}
