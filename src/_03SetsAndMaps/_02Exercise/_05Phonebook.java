package _03SetsAndMaps._02Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05Phonebook {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, String> phoneBookMap = new LinkedHashMap<>();

		String command;
		while(!"search".equals(command = scanner.nextLine())) {
			String[] input = command.split("-");
			String name = input[0];
			String phone = input[1];

			phoneBookMap.put(name, phone);
		}

		while(!"stop".equals(command = scanner.nextLine())) {
			String name = command;

			if(phoneBookMap.containsKey(name)) {
				System.out.printf("%s -> %s%n", name, phoneBookMap.get(name));
			} else {
				System.out.printf("Contact %s does not exist.%n", name);
			}
		}
	}
}
