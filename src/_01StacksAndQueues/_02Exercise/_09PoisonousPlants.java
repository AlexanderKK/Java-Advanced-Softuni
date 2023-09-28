package _01StacksAndQueues._02Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _09PoisonousPlants {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());
		int[] plants = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ArrayDeque<Integer> plantsQueue = new ArrayDeque<>();

		for (int plant : plants) {
			plantsQueue.offer(plant);
		}

		int firstPlant = 0;
		int secondPlant = 0;

		ArrayDeque<Integer> plantsQueue2 = new ArrayDeque<>();
		while(true) {
			if(checkQueue(plantsQueue2)) {
				break;
			}

			if(plantsQueue.size() > 1) {
				firstPlant = plantsQueue.poll();
				secondPlant = plantsQueue.poll();
			} else if(plantsQueue.size() == 1) {
				plantsQueue2.offer(plantsQueue.poll());
			}

			if(firstPlant >= secondPlant) {
				plantsQueue.push(secondPlant);
			}
			plantsQueue2.offer(firstPlant);
		}
	}

	private static boolean checkQueue(ArrayDeque<Integer> queue) {
		if(queue.size() >= 1) {
			int last = queue.peek();
			for (Integer plant : queue) {
				if(plant < last) {

				}
			}
		}
		return true;
	}
}
