package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _04BasicQueueOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int offerCount = firstLine[0];
		int pollCount = firstLine[1];
		int elementToCheck = firstLine[2];

		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		//Push numbers
		offerCount = Math.min(offerCount, numbers.length);

		for (int i = 0; i < offerCount; i++) {
			queue.offer(numbers[i]);
		}

		//Pop numbers
		pollCount = Math.min(pollCount, numbers.length);

		for (int i = 0; i < pollCount; i++) {
			queue.poll();
		}

		Object result;
		if(queue.isEmpty()) {
			result = 0;
		} else if(queue.contains(elementToCheck)) {
			result = true;
		} else {
//			result = getMin(queue);
			result = Collections.min(queue);
		}
		System.out.println(result);
	}

	private static int getMin(ArrayDeque<Integer> queue) {
		int min = Integer.MAX_VALUE;
		for (Integer num : queue) {
			if(num < min) {
				min = num;
			}
		}
		return min;
	}
}
