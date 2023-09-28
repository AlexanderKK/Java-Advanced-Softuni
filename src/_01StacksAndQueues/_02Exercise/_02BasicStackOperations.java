package _01StacksAndQueues._02Exercise;

import java.util.*;

public class _02BasicStackOperations {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//First Line Input - N, S, X
		//N numbers to push from second line
		//S numbers to pop from second line
		//X - check if X element is present in stack : true(if present) otherwise print smallest element
		//if stack is empty print 0

		int[] firstLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int pushCount = firstLine[0];
		int popCount = firstLine[1];
		int elementToCheck = firstLine[2];

		ArrayDeque<Integer> stack = new ArrayDeque<>();
		int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		//Push numbers
		pushCount = Math.min(pushCount, numbers.length);

		for (int i = 0; i < pushCount; i++) {
			stack.push(numbers[i]);
		}

		//Pop numbers
		popCount = Math.min(popCount, numbers.length);

		for (int i = 0; i < popCount; i++) {
			stack.pop();
		}

		Object result;
		if(stack.isEmpty()) {
			result = 0;
		} else if(stack.contains(elementToCheck)) {
			result = true;
		} else {
//			result = getMin(stack);
//			result = Collections.min(stack);
			result = stack.stream().mapToInt(el -> el).min().getAsInt();
		}
		System.out.println(result);
	}

	private static int getMin(ArrayDeque<Integer> stack) {
		int min = Integer.MAX_VALUE;
		for (Integer num : stack) {
			if(num < min) {
				min = num;
			}
		}
		return min;
	}
}
