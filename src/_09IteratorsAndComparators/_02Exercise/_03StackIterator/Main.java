package _09IteratorsAndComparators._02Exercise._03StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();

        String command;
        while(!"END".equals(command = scanner.nextLine())) {
            if (command.startsWith("Push")) {
                int[] numbers = Arrays.stream(command.substring(5).trim().split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                if(numbers.length > 16) {
                    return;
                }

                Arrays.stream(numbers).forEach(stack::push);
            } else if (command.startsWith("Pop")) {
                if (stack.isEmpty()) {
                    System.out.println("No elements");
                } else {
                    stack.pop();
                }
            }
        }

        int counter = 2;
        while(counter-- > 0) {
            for (Integer element : stack) {
                System.out.println(element);
            }
        }

        System.out.println();
    }
}
