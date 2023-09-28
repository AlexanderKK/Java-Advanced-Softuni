package _03SetsAndMaps._01Lab;

import java.util.*;

public class _05AverageStudentsGrades {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, List<Double>> studentsGrades = new TreeMap<>();

		int n = Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < n; i++) {
			String[] input = scanner.nextLine().split(" ");
			String student = input[0];
			double grade = Double.parseDouble(input[1]);

			studentsGrades.putIfAbsent(student, new ArrayList<>());
			studentsGrades.get(student).add(grade);
		}

		studentsGrades.entrySet().stream().forEach(entry -> {
			System.out.printf("%s -> ", entry.getKey());

			entry.getValue().forEach(grade -> System.out.printf("%.2f ", grade));

			double avg = getAvgGrade(entry);
			System.out.printf("(avg: %.2f)%n", avg);

//			System.out.printf("(avg: %.2f)%n", entry.getValue().stream().mapToDouble(e -> e).average().getAsDouble());
		});
	}

	private static double getAvgGrade(Map.Entry<String, List<Double>> entry) {
		double sum = 0;
		for (double grade : entry.getValue()) {
			sum += grade;
		}
		return sum / entry.getValue().size();
	}
}
