package _03SetsAndMaps._02Exercise;

import java.util.*;

public class _03PeriodicTable {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<String> periodicTable = new TreeSet<>();

		int n = Integer.parseInt(scanner.nextLine());
		while(n-- > 0) {
			String[] elements = scanner.nextLine().split(" ");

			Collections.addAll(periodicTable, elements);

//			periodicTable.addAll(Arrays.asList(elements));
//
//			for (String chemicalElement : elements) {
//				periodicTable.add(chemicalElement);
//			}
		}

		System.out.println(String.join(" ", periodicTable));
	}
}
