package _03SetsAndMaps._02Exercise;

import java.util.*;

public class _02SetsOfElements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<Integer> setN = new LinkedHashSet<>();
		Set<Integer> setM = new LinkedHashSet<>();

		String line = scanner.nextLine();
		int n = Integer.parseInt(line.split(" ")[0]);
		int m = Integer.parseInt(line.split(" ")[1]);

		for (int i = 0; i < n; i++) {
			setN.add(Integer.parseInt(scanner.nextLine()));
		}

		for (int i = 0; i < m; i++) {
			setM.add(Integer.parseInt(scanner.nextLine()));
		}

		setN.retainAll(setM);
		for (Integer integer : setN) {
			System.out.print(integer + " ");
		}
//		printRepeatingNumbers(setN, setM);
	}

	private static void printRepeatingNumbers(Set<Integer> setN, Set<Integer> setM) {
		for (int numN : setN) {
			for (int numM : setM) {
				if(numN == numM) {
					System.out.print(numN + " ");
					break;
				}
			}
		}
	}
}
