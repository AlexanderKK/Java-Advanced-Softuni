package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _02SimpleCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//2 + 5 + 10 - 2 - 1
		String input = scanner.nextLine();

		ArrayDeque<String> calculator = new ArrayDeque<>();

		//Add elements to queue
		Arrays.stream(input.split("\\s+")).forEach(el -> calculator.offer(el));

		int first = 0;
		while(calculator.size() > 0) {
			if(!calculator.peek().equals("+") && !calculator.peek().equals("-")) {
				first = Integer.parseInt(calculator.poll());
			}

			String operator = calculator.poll();
			if(operator.equals("+")) {
				first += Integer.parseInt(calculator.poll());
			} else if(operator.equals("-")) {
				first -= Integer.parseInt(calculator.poll());
			}
		}
//		calculator.offer(String.valueOf(first));
//		System.out.println(calculator.pop());

		System.out.println(first);
	}
}
