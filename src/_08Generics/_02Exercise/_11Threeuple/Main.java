package _08Generics._02Exercise._11Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String name = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];

        Threeuple<String, String, String> firstThreeuple = new Threeuple<>(name, address, town);
        System.out.println(firstThreeuple);

        input = scanner.nextLine().split("\\s+");

        String firstName = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        String drunkOrNot = input[2];
        boolean flag = drunkOrNot.equals("drunk");

        Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(firstName, litersOfBeer, flag);
        System.out.println(secondThreeuple);

        input = scanner.nextLine().split("\\s+");

        String nickname = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(nickname, accountBalance, bankName);
        System.out.println(thirdThreeuple);
    }
}
