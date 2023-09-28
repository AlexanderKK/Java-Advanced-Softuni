package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03DecimalToBinary {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//10 -> 1010
		ArrayDeque<Integer> binaryDigits = new ArrayDeque<>();

		int decimal = Integer.parseInt(scanner.nextLine());

		if(decimal == 0) {
			System.out.println(decimal);
		}

		while(decimal > 0) {
			binaryDigits.push(decimal % 2);
			decimal /= 2;
		}

		for (Integer digit : binaryDigits) {
			System.out.print(digit + "");
		}
	}
}
