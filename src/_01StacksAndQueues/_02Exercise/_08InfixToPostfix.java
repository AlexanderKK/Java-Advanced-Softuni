package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08InfixToPostfix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. Add numbers to output queue
		//2. Push operators to operator stack
		//3. Add numbers and then operators to output

		ArrayDeque<String> outputQueue = new ArrayDeque<>();
		ArrayDeque<String> operatorStack = new ArrayDeque<>();

		String[] input = scanner.nextLine().split(" ");
		for (String token : input) {
			if (token.matches("\\d+")) {
				outputQueue.offer(token);
			} else if (token.equals("(")) {
				operatorStack.push(token);
			} else if (token.equals(")")) {
				while (!operatorStack.peek().equals("(")) {
					outputQueue.offer(operatorStack.pop());
				}
				operatorStack.pop();
			} else {
				if ("-+".contains(token)) {
					while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
						outputQueue.offer(operatorStack.pop());
					}
				} else {
					while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
						outputQueue.offer(operatorStack.pop());
					}
				}
				operatorStack.push(token);
			}
		}
		while (!operatorStack.isEmpty()) {
			outputQueue.offer(operatorStack.pop());
		}
		System.out.println(String.join(" ", outputQueue));
	}
}
