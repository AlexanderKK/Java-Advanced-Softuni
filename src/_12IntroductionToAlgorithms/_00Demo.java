package _12IntroductionToAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class _00Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumArr(numbers, 0);
        System.out.println(sum);
    }

    private static int sumArr(int[] arr, int index) {
        if(index >= arr.length) {
            return 0;
        }

        //Pre call
        int currentSum = sumArr(arr, index + 1);

        //Post call
        System.out.println(arr[index] + " " + currentSum);

        return arr[index] + currentSum;
    }
}
