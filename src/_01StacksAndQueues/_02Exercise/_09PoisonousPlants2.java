package _01StacksAndQueues._02Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09PoisonousPlants2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		List<Integer> plants = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

		if(plants.size() >= 1 && plants.size() <= 100000) {
			List<Integer> indices = new ArrayList<>();

			int days = 0;
			while(checkForDyingPlant(plants)) {
				for (int i = 0; i < plants.size() - 1; i++) {
					if(plants.get(i) < plants.get(i + 1)) {
						indices.add(i + 1);
					}
				}

				for (int i = 0; i < indices.size(); i++) {
					if(i > 0) {
						indices.set(i, indices.get(i) - i);
					}
					int index = indices.get(i);

					plants.remove(index);
				}

				indices.clear();
				days++;
			}
			System.out.println(days);
		}
	}

	private static boolean checkForDyingPlant(List<Integer> plants) {
		for (int i = 0; i < plants.size() - 1; i++) {
			if(plants.get(i) < plants.get(i + 1)) {
				return true;
			}
		}
		return false;
	}
}
