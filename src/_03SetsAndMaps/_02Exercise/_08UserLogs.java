package _03SetsAndMaps._02Exercise;

import java.util.*;

public class _08UserLogs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Integer>> userMessages = new TreeMap<>();

		String command;
		while(!"end".equals(command = scanner.nextLine())) {
			String[] input = command.split(" ");
			String IP = input[0].split("=")[1];
			String user = input[2].split("=")[1];

			userMessages.putIfAbsent(user, new LinkedHashMap<>());
			userMessages.get(user).putIfAbsent(IP, 0);
			userMessages.get(user).put(IP, userMessages.get(user).get(IP) + 1);
		}

		for (String user : userMessages.keySet()) {
			System.out.println(user + ": ");

			int it = 0;
			Map<String, Integer> IPs = userMessages.get(user);
			for (String IP : IPs.keySet()) {
				int count = IPs.get(IP);

				if(it == IPs.size() - 1) {
					System.out.printf("%s => %d.%n", IP, count);
				} else {
					System.out.printf("%s => %d, ", IP, count);
				}

				it++;
			}
		}
	}
}
