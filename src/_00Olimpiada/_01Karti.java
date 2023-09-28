package _00Olimpiada;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _01Karti {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int cardsInDeck = Integer.parseInt(input.split(" ")[0]);
        int cardSplits = Integer.parseInt(input.split(" ")[1]);

        if(cardsInDeck >= 1 && cardsInDeck <= 50 && cardSplits >= 1 && cardSplits <= 50) {
            List<Integer> deck = IntStream.range(1, cardsInDeck + 1).boxed().collect(Collectors.toList());
            Collections.reverse(deck);

            while(cardSplits-- > 0) {
                String[] inputSplit = scanner.nextLine().split(" ");
                int cardBeginSplit = Integer.parseInt(inputSplit[0]);
                int cardsToMove = Integer.parseInt(inputSplit[1]);

                if(cardBeginSplit + cardsToMove <= cardsInDeck + 1) {
                    for (int i = 0; i < cardsToMove; i++) {
                        int index = cardBeginSplit - 1;
                        if(index >= 0 && index <= deck.size() - 1) {
                            deck.add(0, deck.get(index));
                            deck.remove(index + 1);
                        }
                    }
                }
            }
            System.out.println(deck.get(0));
        }
    }
}
