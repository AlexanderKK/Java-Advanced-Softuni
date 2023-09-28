package _03SetsAndMaps._01Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _08AcademyGraduation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, Double> studentsMap = new TreeMap<>();

		int rows = Integer.parseInt(scanner.nextLine());
		while(--rows >= 0) {
			String student = scanner.nextLine();
			double avgGrade = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).average().orElse(0);

			//Add Student and Average Grade
			studentsMap.put(student, avgGrade);
		}

		DecimalFormat df = new DecimalFormat("#.###########");
		studentsMap.forEach((student, grade) -> System.out.printf("%s is graduated with %s%n", student, df.format(grade)));
	}
}
