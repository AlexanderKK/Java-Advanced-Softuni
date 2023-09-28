package _03SetsAndMaps._02Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class _01UniqueUsernames {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		LinkedHashSet<String> usernamesSet = new LinkedHashSet<>();

		int n = Integer.parseInt(scanner.nextLine());
		while(n-- > 0) {
			String username = scanner.nextLine();

			usernamesSet.add(username);
		}

		for (String username : usernamesSet) {
			System.out.println(username);
		}
	}
}