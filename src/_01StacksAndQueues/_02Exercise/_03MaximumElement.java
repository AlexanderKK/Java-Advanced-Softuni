package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _03MaximumElement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Accept N lines ot input
		//Types of commands:
		//1. 1 X - push to stack
		//2. 2 - remove from stack
		//3. 3 - print max element from stack

		ArrayDeque<Integer> stack = new ArrayDeque<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			int[] line = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int cmd = line[0];

			if(cmd == 1) {
				stack.push(line[1]);
			} else if(cmd == 2) {
				stack.pop();
			} else if(cmd == 3) {
//				System.out.println(getMax(stack));
//				System.out.println(stack.stream().mapToInt(e -> e).max().getAsInt());
				System.out.println(Collections.max(stack));
			}
		}
	}

	private static int getMax(ArrayDeque<Integer> stack) {
		int max = Integer.MIN_VALUE;
		for (Integer num : stack) {
			if(num > max) {
				max = num;
			}
		}
		return max;
	}
}
