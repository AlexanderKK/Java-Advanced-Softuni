package _05FunctionalProgramming._02Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" ")).forEach(e -> System.out.println("Sir " + e));
    }
}
