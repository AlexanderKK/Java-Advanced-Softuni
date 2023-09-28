package _03SetsAndMaps._01Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02SoftUniParty {
	public static Set<String> vip = new TreeSet<>();
	public static Set<String> regular = new TreeSet<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String command;
		while(!"PARTY".equals(command = scanner.nextLine())) {
			String guest = command;

			addGuests(guest);
		}

		while(!"END".equals(command = scanner.nextLine())) {
			String guest = command;

			removeGuests(guest);
		}

		System.out.println(vip.size() + regular.size());

		printGuests(vip);

		printGuests(regular);
	}

	private static void removeGuests(String guest) {
		if(Character.isDigit(guest.charAt(0))) {
			vip.remove(guest);
		} else {
			regular.remove(guest);
		}
	}

	private static void addGuests(String guest) {
		if(Character.isDigit(guest.charAt(0))) {
			vip.add(guest);
		} else {
			regular.add(guest);
		}
	}

	private static void printGuests(Set<String> guestList) {
		for (String guest : guestList) {
			System.out.println(guest);
		}
	}
}
