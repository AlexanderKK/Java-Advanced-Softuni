package _12IntroductionToAlgorithms;

import java.util.*;

public class _03SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] availableCoins = Arrays.stream(scanner.nextLine().split("Coins: ")[1].split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine().split("Sum: ")[1]);

        try {
            Map<Integer, Integer> selectedCoins = chooseCoins(availableCoins, targetSum);

            print(selectedCoins);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void print(Map<Integer, Integer> selectedCoins) {
        int sumCoins = selectedCoins.values().stream().mapToInt(e -> e).sum();
        System.out.printf("Number of coins to take: %d%n", sumCoins);

        selectedCoins.forEach((coin, numberOfCoins) -> System.out.printf("%d coin(s) with value %d%n", numberOfCoins, coin));
    }

    public static Map<Integer, Integer> chooseCoins(int[] availableCoins, int targetSum) {
        Map<Integer, Integer> coins = new LinkedHashMap<>();

        int index = availableCoins.length - 1;

        while(targetSum != 0) {
            if(index < 0) {
                throw new IllegalStateException("Error");
            }

            int currentCoin = availableCoins[index--];

            int numberOfCoins = targetSum / currentCoin;
            targetSum %= currentCoin;

            if(numberOfCoins != 0) {
                coins.put(currentCoin, numberOfCoins);
            }
        }

        return coins;
    }
}
