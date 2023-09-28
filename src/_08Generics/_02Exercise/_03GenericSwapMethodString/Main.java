package _08Generics._02Exercise._03GenericSwapMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            box.add(input);
        }

        String[] input = scanner.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(input[0]);
        int secondIndex = Integer.parseInt(input[1]);

        String firstElement = box.get(firstIndex);
        String secondElement = box.get(secondIndex);
        box.set(firstIndex, secondElement);
        box.set(secondIndex, firstElement);

        System.out.println(box);
    }
}
