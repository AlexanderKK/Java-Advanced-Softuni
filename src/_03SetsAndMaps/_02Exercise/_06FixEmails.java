package _03SetsAndMaps._02Exercise;

import java.util.*;

public class _06FixEmails {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String> addressBook = new LinkedHashMap<>();

		String command;
		while(!"stop".equals(command = scanner.nextLine())) {
			String name = command;
			String email = scanner.nextLine();

			if(!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
				addressBook.put(name, email);
			}
		}

		addressBook.forEach((name, email) -> System.out.printf("%s -> %s%n", name, email));
	}
}