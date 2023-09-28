package _03SetsAndMaps._01Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.LinkedHashSet;

public class _01ParkingLot {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Set<String> parkingLot = new LinkedHashSet<>();
		String command;
		while(!"END".equals(command = scanner.nextLine())) {
			String[] input = command.split(",\\s+");
			String cmd = input[0];
			String car = input[1];

			if(cmd.equals("IN")) {
				parkingLot.add(car);
			} else if(cmd.equals("OUT")) {
				parkingLot.remove(car);
			}
		}

		if(parkingLot.isEmpty()) {
			System.out.println("Parking Lot is Empty");
		} else {
			for (String car : parkingLot) {
				System.out.println(car);
			}
		}
	}
}
