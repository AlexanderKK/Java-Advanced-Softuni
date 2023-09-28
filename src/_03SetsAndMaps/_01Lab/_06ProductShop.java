package _03SetsAndMaps._01Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06ProductShop {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Map<String, Double>> shops = new TreeMap<>();

		String command = scanner.nextLine();
		while(!"Revision".equals(command)) {
			String[] input = command.split(",\\s+");
			String shop = input[0];
			String product = input[1];
			double price = Double.parseDouble(input[2]);

			shops.putIfAbsent(shop, new LinkedHashMap<>());
			shops.get(shop).put(product, price);

			command = scanner.nextLine();
		}

		shops.forEach((shop, products) -> {
			System.out.printf("%s->%n", shop);

			products.forEach((product, price) -> System.out.printf("Product: %s, Price: %.1f%n", product, price));
		});
	}
}
