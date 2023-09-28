package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _06HotPotato {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		1. Using Queue

		//Sam John Sara - players
		String input = scanner.nextLine();

		//N times tossed potato
		int n = Integer.parseInt(scanner.nextLine());

		//Players queue
		ArrayDeque<String> players = new ArrayDeque<>();

		//Add elements to queue
		Arrays.stream(input.split("\\s+")).forEach(el -> players.offer(el));

		int tosses = 1;
		while(players.size() > 1) {
			//Remove player
			String player = players.poll();
			if (tosses != n) {
				//Add player to end of queue
				players.offer(player);
			} else {
				//If we reach the unlucky toss, player is left removed
				System.out.printf("Removed %s%n", player);

				//Reset tosses, so we can enter again in this else construction, otherwise tosses will remain greater than n
				tosses = 0;
			}

			//Toss potato to another player
			tosses++;
		}
		System.out.printf("Last is %s%n", players.poll());
	}
}
