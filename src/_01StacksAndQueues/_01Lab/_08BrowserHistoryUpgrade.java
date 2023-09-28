package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _08BrowserHistoryUpgrade {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. Input line -> url | back | forward
		//2. If url -> queue & stack
		//3. if cmd is back -> if stack is not empty I remove first element and return next & in queue
		//4. if cmd is forward -> if queue is not empty I remove first element and return next

		ArrayDeque<String> historyBack = new ArrayDeque<>();
		ArrayDeque<String> historyForward = new ArrayDeque<>();
		String currentURL = null;

		String input;
		while(!"Home".equals(input = scanner.nextLine())) {
			if(input.equals("back")) {
				if(!historyBack.isEmpty()) {
					historyForward.clear();
					historyForward.push(currentURL);
					currentURL = historyBack.pop();
				} else {
					System.out.println("no previous URLs");
					historyForward.clear();
					continue;
				}
			} else if(input.equals("forward")) {
				if(!historyForward.isEmpty()) {
					historyBack.push(currentURL);
					currentURL = historyForward.pop();
				} else {
					System.out.println("no next URLs");
					continue;
				}
			} else {
				if(currentURL != null) {
					historyBack.push(currentURL);
				}
				currentURL = input;
			}
			System.out.println(currentURL);
		}
	}
}
