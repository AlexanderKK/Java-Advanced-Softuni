package _00Olimpiada;

import java.util.Arrays;
import java.util.Scanner;

public class _05Zlato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int max = Arrays.stream(numbers)
                .max()
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(max / numbers.length);
    }
}
