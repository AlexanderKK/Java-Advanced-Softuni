package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01BrowserHistory {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ArrayDeque<String> history = new ArrayDeque<>();

		String currentUrl = null;
		String input;
		while(!"Home".equals(input = scanner.nextLine())) {
			if(input.equals("back")) {
				if(history.isEmpty()) {
					System.out.println("no previous URLs");
					continue;
				} else {
					currentUrl = history.pop();
				}
			} else {
				if(currentUrl != null) {
					history.push(currentUrl);
				}
				currentUrl = input;
			}
			System.out.println(currentUrl);
		}
	}
}
