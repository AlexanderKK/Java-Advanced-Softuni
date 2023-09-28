package _03SetsAndMaps._02Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class _09PopulationCounter {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Long>> populationMap = new LinkedHashMap<>();

		String command;
		while(!"report".equals(command = scanner.nextLine())) {
			String[] input = command.split("\\|");

			String country = input[1];
			String city = input[0];
			long population = Long.parseLong(input[2]);

			populationMap.putIfAbsent(country, new HashMap<>());
			populationMap.get(country).put(city, population);
		}

		Map<String, Long> countriesPopulationMap = new LinkedHashMap<>();

		//Countries -> population
		for (String country : populationMap.keySet()) {
			long totalPopulation = 0L;

			Map<String, Long> cities = populationMap.get(country);
			for (String city : cities.keySet()) {
				totalPopulation += cities.get(city);
			}
			countriesPopulationMap.put(country, totalPopulation);
		}

		//Sort Countries By Population
		Map<String, Long> countriesSorted = sortMapByValueDescending(countriesPopulationMap);

		for (String country : countriesSorted.keySet()) {
			Map<String, Long> cities = populationMap.get(country);

			//Sort Cities By Population
			Map<String, Long> citiesSorted = sortMapByValueDescending(cities);

			//Print country's total population
			long totalPopulation = countriesSorted.get(country);
			System.out.printf("%s (total population: %d)%n", country, totalPopulation);

			//Print country's cities population
			for (String city : citiesSorted.keySet()) {
				System.out.printf("=>%s: %d%n", city, citiesSorted.get(city));
			}
		}
	}

	private static Map<String, Long> sortMapByValueDescending(Map<String, Long> countriesPopulationMap) {
		Map<String, Long> countriesSorted = countriesPopulationMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		return countriesSorted;
	}
}
