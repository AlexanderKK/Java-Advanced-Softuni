package _08Generics._02Exercise._04GenericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Integer> box = new Box();
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            box.add(number);
        }

        String[] input = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);

        box.swap(firstIndex, secondIndex);

        System.out.println(box);
    }
}
