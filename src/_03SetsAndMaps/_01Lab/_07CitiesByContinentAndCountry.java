package _03SetsAndMaps._01Lab;

import java.util.*;

public class _07CitiesByContinentAndCountry {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, List<String>>> continentsMap = new LinkedHashMap<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split("\\s+");
			String continent = input[0];
			String country = input[1];
			String city = input[2];

			//Add continent if not present
			continentsMap.putIfAbsent(continent, new LinkedHashMap<>());
			//Add country if not present
			continentsMap.get(continent).putIfAbsent(country, new ArrayList<>());
			//Add city
			continentsMap.get(continent).get(country).add(city);
		}

		for (String continent : continentsMap.keySet()) {
			System.out.println(continent + ":");

			continentsMap.get(continent).forEach((country, cities) -> {
				System.out.printf("  %s -> %s%n", country, String.join(", ", cities));
			});
		}

//		continentsMap.forEach((continent, countriesMap) -> {
//			System.out.println(continent + ":");
//
//			countriesMap.forEach((country, cities) -> {
//				System.out.printf("\s\s%s -> %s%n", country, String.join(", ", cities));
//			});
//		});
	}
}
