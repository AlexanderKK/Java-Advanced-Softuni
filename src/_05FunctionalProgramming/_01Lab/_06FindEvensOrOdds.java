package _05FunctionalProgramming._01Lab;

import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        String condition = scanner.nextLine();

        IntPredicate numFilter = n -> condition.equals("odd") == (n % 2 != 0);
//        IntPredicate numFilter = n -> condition.equals("odd")
//                                        ? n % 2 != 0
//                                        : n % 2 == 0;
//        IntPredicate numFilter = getFilter(condition);

        System.out.println(
                IntStream.range(start, end + 1)
                .filter(numFilter)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }

//    private static IntPredicate getFilter (String condition) {
//        return condition.equals("odd") ? n -> n % 2 != 0 : n -> n % 2 == 0;
//    }
}
