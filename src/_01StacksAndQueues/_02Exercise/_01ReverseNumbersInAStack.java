package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01ReverseNumbersInAStack {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(stack::push);

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}
