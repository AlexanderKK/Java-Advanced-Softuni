package _03SetsAndMaps._02Exercise;

import java.util.*;

public class _07HandsOfCards {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, LinkedHashSet<String>> players = new LinkedHashMap<>();
		Map<String, Integer> cardPower = Map.of("J", 11, "Q", 12, "K", 13, "A", 14);
		Map<Character, Integer> cardTypes = Map.of('S', 4, 'H', 3, 'D', 2, 'C', 1);

		String command;
		while(!"JOKER".equals(command = scanner.nextLine())) {
			String name = command.split(": ")[0];
			String[] cards = command.split(": ")[1].split(",\\s+");

			//1. Write data

			//Add player
			players.putIfAbsent(name, new LinkedHashSet<>());

			//Add cards to player
			for (String card : cards) {
				players.get(name).add(card);
			}
		}

		players.forEach((player, cards) -> {
			int totalScore = 0;

			for (String card : cards) {
				String firstToken = "";
				char secondToken = ' ';

				if (card.length() == 2) {   //If for example we have QS
					firstToken = card.charAt(0) + "";   //Q
					secondToken = card.charAt(1);   //S
				} else if (card.length() == 3) {   //If for example we have 10C
					firstToken = card.charAt(0) + "" + card.charAt(1);   //10
					secondToken = card.charAt(2);   //C
				}

				//cardPower (2, 3, 4, 5, 6, 7, 8, 9, 10, J, D, K, A)
				//cardType (J, D, K, A)

				if (Character.isLetter(firstToken.charAt(0))) {   //If it is letter (J, D, K, A)
					totalScore += cardPower.get(firstToken) * cardTypes.get(secondToken);
				} else {   //If it is digit (2 - 10)
					totalScore += Integer.parseInt(firstToken) * cardTypes.get(secondToken);
				}
			}

			//Get player score
			System.out.printf("%s: %d%n", player, totalScore);
		});
	}
}
