package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _07MathPotato {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		int n = Integer.parseInt(scanner.nextLine());

		ArrayDeque<String> players = new ArrayDeque<>();
		Arrays.stream(input.split("\\s+")).forEach(el -> players.offer(el));

		//Declared tosses and cycle variables
		int tosses = 1;
		int cycle = tosses;
		String player;

		while(players.size() > 1) {
			if(tosses == n) {
				if(!isPrime(cycle)) {   //If cycle is not prime, only then remove the player from queue
					player = players.poll();
					System.out.printf("Removed %s%n", player);
				} else {				//If cycle is prime, then return unlucky player without removing him/her
					player = players.peek();
					System.out.printf("Prime %s%n", player);
				}

				//Reset tosses and increase cycles
				tosses = 0;
				cycle++;
			} else {   					//If not reached Nth toss -> add to end of queue first element
				player = players.poll();
				players.offer(player);
			}

			//Increase tosses with one
			tosses++;
		}

		//Print last standing player
		System.out.printf("Last is %s%n", players.poll());
	}

	private static boolean isPrime(int number) {
		if(number <= 1) {
			return false;
		}

		for (int i = 2; i < number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
