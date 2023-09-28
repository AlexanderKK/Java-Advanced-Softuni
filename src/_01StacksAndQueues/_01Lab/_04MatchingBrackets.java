package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04MatchingBrackets {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5

		//1. Въвеждам входни данни - string
		//2. Обхождам стринга от символи
		//3. При намерена отваряща скоба записвам индекса в стек
		//4. Ако намеря затваряща след отварящата скоба, извеждам substring(startIndex - Отваряща, endIndex - Затваряща) и изтривам startIndex
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		String input = scanner.nextLine();
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (c == '(') {
				stack.push(i);
			} else if(c == ')') {
				if(!stack.isEmpty()) {
					int startIndex = stack.pop();
					int endIndex = i + 1;

					String expression = input.substring(startIndex, endIndex);
					System.out.println(expression);
				}
			}
		}
	}
}
