package _01StacksAndQueues._02Exercise;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Scanner;

public class _08InfixToPostfix2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] input = scanner.nextLine().split("\\s+");

		ArrayDeque<String> outputQueue = new ArrayDeque<>();
		ArrayDeque<String> operatorStack = new ArrayDeque<>();

		for (String el : input) {
			if(el.matches("\\d+\\.?\\d*")) {   //Add to queue if a number is found
				outputQueue.offer(el);
			} else if(el.equals("(")) {   //Add to stack if "(" is found
				operatorStack.push(el);
			} else if(el.equals(")")) {   //If ")" is found ->
				while(!operatorStack.peek().equals("(")) {
					outputQueue.offer(operatorStack.pop());   //pop from stack and add to queue until "(" is reached in stack
				}
				operatorStack.pop();   //pop "(" from stack
			} else if(el.equals("+") || el.equals("-")) {   //If "-" or "+" is found ->
				while(!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
					outputQueue.offer(operatorStack.pop());   //If operator in stack != "(" {*, /, %, ...} - pop from stack and add to queue
				}

				operatorStack.push(el);   //Push current operator to stack
			} else {   //If anything different from "-" or "+" is found {*, /, %, x, y, ...}
				while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
					outputQueue.offer(operatorStack.pop());   //If operator in stack != "(" or "+" or "-" {*, /, %, ...} - pop from stack and add to queue
				}

				operatorStack.push(el);   //Push current operator to stack
			}
		}

		while(!operatorStack.isEmpty()) {   //Add remaining elements in operator stack into the output queue
			outputQueue.offer(operatorStack.pop());
		}
		System.out.println(String.join(" ", outputQueue));   //Print output queue elements joined by a space delimiter

		ArrayDeque<BigDecimal> result = new ArrayDeque<>();
		while(!outputQueue.isEmpty()) {
			String currentEl = outputQueue.poll();
			if(currentEl.matches("\\d+\\.?\\d*")) {
				result.push(new BigDecimal(currentEl));
				continue;
			}
			char operator = currentEl.charAt(0);

			BigDecimal secondNumber = new BigDecimal(String.valueOf(result.pop()));
			BigDecimal firstNumber = new BigDecimal(String.valueOf(result.pop()));

			if(operator == '+') {
				result.push(firstNumber.add(secondNumber));
			} else if(operator == '-') {
				result.push(firstNumber.subtract(secondNumber));
			} else if(operator == '*') {
				result.push(firstNumber.multiply(secondNumber));
			} else if(operator == '/') {
				if(secondNumber.compareTo(new BigDecimal(0 + "")) == 0) {
					System.out.println("Cannot divide by 0");
					return;
				}
				result.push(firstNumber.divide(secondNumber, BigDecimal.ROUND_HALF_UP));
			}
		}
		String resultStr = String.valueOf(result.pop());
		if(resultStr.matches("\\d+\\.?0")) {
			resultStr = resultStr.substring(0, resultStr.indexOf("."));
		}
		System.out.println(resultStr);
	}
}
