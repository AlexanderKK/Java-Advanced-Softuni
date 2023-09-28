package _03SetsAndMaps._01Lab;

import java.util.*;
import java.util.stream.Collectors;

public class _04CountRealNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		double[] numbers = Arrays.stream(scanner.nextLine().split("\\s{1,}")).mapToDouble(Double::parseDouble).toArray();
		Map<Double, Integer> numCounts = new LinkedHashMap<>();

		for (double number : numbers) {
			numCounts.putIfAbsent(number, 0);
			numCounts.put(number, numCounts.get(number) + 1);
		}

		numCounts.forEach((k, v) -> {
			System.out.printf("%.1f -> %d%n", k, v);
		});
	}
}
