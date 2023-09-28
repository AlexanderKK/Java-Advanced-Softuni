package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03DecimalToBinary2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimal = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryDigits = new ArrayDeque<>();

        if(decimal == 0) {
            System.out.println(0);
        }

        while(decimal > 0) {
            int remainder = decimal % 2;
            binaryDigits.push(remainder);
            decimal /= 2;
        }

        while(!binaryDigits.isEmpty()) {
            System.out.print(binaryDigits.pop() + "");
        }
    }
}
