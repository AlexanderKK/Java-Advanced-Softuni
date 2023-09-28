package _08Generics._02Exercise._10Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];

        Tuple<String, String> firstTuple = new Tuple<>(name, address);

        input = scanner.nextLine().split("\\s+");

        String firstName = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);

        Tuple<String, Integer> secondTuple = new Tuple<>(firstName, litersOfBeer);

        input = scanner.nextLine().split("\\s+");

        int integer = Integer.parseInt(input[0]);
        double decimal = Double.parseDouble(input[1]);

        Tuple<Integer, Double> thirdTuple = new Tuple<>(integer, decimal);

        System.out.println(firstTuple);
        System.out.println(secondTuple);
        System.out.println(thirdTuple);
    }
}
