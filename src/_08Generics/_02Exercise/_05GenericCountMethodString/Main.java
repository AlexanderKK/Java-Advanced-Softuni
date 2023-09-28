package _08Generics._02Exercise._05GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            box.add(input);
        }

        String comparingValue = scanner.nextLine();
        System.out.println(box.getGreaterCount(comparingValue));
    }
}
