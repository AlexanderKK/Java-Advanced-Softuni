package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);

        Comparator<Integer> comparator = (first, second) -> {
            if(first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if(first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            return first.compareTo(second);
        };

//        String result = list.stream()
//                .sorted(comparator)
//                .map(String::valueOf)
//                .collect(Collectors.joining(" "));
//
//        System.out.println(result);

        Arrays.sort(numbers, comparator);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}
