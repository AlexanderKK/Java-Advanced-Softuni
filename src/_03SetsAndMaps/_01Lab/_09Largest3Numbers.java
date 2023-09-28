package _03SetsAndMaps._01Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09Largest3Numbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

//		List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
//				.map(Integer::parseInt)
//				.sorted((num1, num2) -> num2.compareTo(num1))
//				.collect(Collectors.toList());
//
//		for (int i = 0; i < 3 ; ++i) {
//			if(i == numbers.size()) {
//				break;
//			}
//			System.out.print(numbers.get(i) + " ");
//		}

		String result = Arrays.stream(scanner.nextLine().split(" "))
				.map(Integer::parseInt)
				.sorted((num1, num2) -> num2.compareTo(num1))
				.limit(3)
				.map(String::valueOf)
				.collect(Collectors.joining(" "));
		System.out.println(result);
	}
}
