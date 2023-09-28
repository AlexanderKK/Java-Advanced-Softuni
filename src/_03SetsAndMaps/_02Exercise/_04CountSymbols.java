package _03SetsAndMaps._02Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04CountSymbols {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<Character, Integer> charMap = new TreeMap<>();

		char[] text = scanner.nextLine().toCharArray();
		for (char c : text) {
			charMap.putIfAbsent(c, 0);
			charMap.put(c, charMap.get(c) + 1);
		}

		charMap.forEach((letter, count) -> System.out.printf("%c: %d time/s%n", letter, count));
	}
}
