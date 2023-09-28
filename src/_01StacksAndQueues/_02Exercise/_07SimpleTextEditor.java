package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _07SimpleTextEditor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1 {string}" - appends [string] to the end of the text.
		//2 {count}" - erases the last [count] elements from the text.
		//3 {index}" - returns the element at position [index] from the text.
		//4 - undoes the last not-undone command of type 1 or 2 and returns the text to the state before that operation.

		ArrayDeque<String> textStates = new ArrayDeque<>();
		StringBuilder currentText = new StringBuilder();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();

			if(input.startsWith("1")) {
				//Push last text state
				textStates.push(currentText.toString());

				String str = input.split(" ")[1];
				currentText.append(str);
			} else if(input.startsWith("2")) {
				//Push last text state
				textStates.push(currentText.toString());

				int count = Integer.parseInt(input.split(" ")[1]);

				//Escape index out of boundaries exception
				int minValue = Math.min(count, currentText.length());

				int startIndexToDelete = currentText.length() - minValue;

				currentText.delete(startIndexToDelete, currentText.length());
			} else if(input.startsWith("3")) {
				int index = Integer.parseInt(input.split(" ")[1]);

				if(index >= 1 && index <= currentText.length()) {
					System.out.println(currentText.charAt(index - 1));
				}
			} else if(input.equals("4")) {
				//Pop last state and set text to the last returned
				if(!textStates.isEmpty()) {
					currentText.delete(0, currentText.length());
					currentText = new StringBuilder(textStates.pop());
				}
			}
		}
	}
}
