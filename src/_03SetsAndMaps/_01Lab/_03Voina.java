package _03SetsAndMaps._01Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _03Voina {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(LinkedHashSet::new));

		LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toCollection(LinkedHashSet::new));

		int rounds = 50;
		while(rounds-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
			int firstCard = firstDeck.iterator().next();
			firstDeck.remove(firstCard);

			int secondCard = secondDeck.iterator().next();
			secondDeck.remove(secondCard);

			if(firstCard > secondCard) {
				firstDeck.add(firstCard);
				firstDeck.add(secondCard);
			} else if(firstCard < secondCard) {
				secondDeck.add(firstCard);
				secondDeck.add(secondCard);
			}
		}

		if(firstDeck.size() > secondDeck.size()) {
			System.out.println("First player win!");
		} else if(secondDeck.size() > firstDeck.size()) {
			System.out.println("Second player win!");
		} else {
			System.out.println("Draw!");
		}
	}
}
