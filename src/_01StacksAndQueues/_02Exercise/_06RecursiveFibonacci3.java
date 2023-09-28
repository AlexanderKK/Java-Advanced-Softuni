package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06RecursiveFibonacci3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayDeque<Long> sequence = new ArrayDeque<>();
		int n = Integer.parseInt(scanner.nextLine());
		sequence.push(0L);
		sequence.push(1L);

		if(n < 2) {
			System.out.println(1);
			return;
		}

		for (int i = 0; i < n; i++) {
			//0 1 -> 1 1 | last = 1 & first = 0
			long last = sequence.pop();
			long first = sequence.pop();

			//stack will be -> 1(last) 1(0[first] + 1[last])
			sequence.push(last);
			sequence.push(first + last);
		}

		System.out.println(sequence.pop());
		//2 3 -> 3 5 -> 5 8 -> 8 13 -> 13 21 -> 21 34 -> 34 55 ...
	}
}
