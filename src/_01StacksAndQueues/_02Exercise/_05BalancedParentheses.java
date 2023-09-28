package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _05BalancedParentheses {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		//1. Check for opening brackets and push them to stack
		//2. Loop through brackets input line and check if there are closing brackets
		//3. If a closing bracket is found -> return and remove the last opening bracket
		//4. Check if opening and closing are the same -> if not -> print NOT BALANCED else continue to next iteration
		//5. If there are still closing brackets left in the input and there are no opening ones in the stack -> NOT BALANCED
		//6. If there are opening brackets in stack, but no closing brackets left -> NOT BALANCED

		//{[(])]} -> NOT BALANCED
		//{()()} -> BALANCED
		//(() -> NOT BALANCED

		String brackets = scanner.nextLine();
		Deque<Character> openingBrackets = new ArrayDeque<>();
		boolean isBalanced = true;

		for (char currentBracket : brackets.toCharArray()) {
			if(currentBracket == '(' || currentBracket == '[' || currentBracket == '{') {
				openingBrackets.push(currentBracket);
			} else {
				if(openingBrackets.isEmpty()) {
					isBalanced = false;
					break;
				}

				if(currentBracket == ')' && openingBrackets.pop() != '(') {
					isBalanced = false;
					break;
				} else if(currentBracket == ']' && openingBrackets.pop() != '[') {
					isBalanced = false;
					break;
				} else if(currentBracket == '}' && openingBrackets.pop() != '{') {
					isBalanced = false;
					break;
				}
			}
		}

		if(isBalanced && openingBrackets.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}