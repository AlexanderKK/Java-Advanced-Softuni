package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _02PositionsOf {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Get rows and cols
		int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			System.arraycopy(inputArr, 0, matrix[i], 0, cols);
		}

		int number = Integer.parseInt(scanner.nextLine());
		boolean isFound = false;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == number) {
					isFound = true;
					System.out.println(i + " " + j);
				}
			}
		}

		if(!isFound) {
			System.out.println("not found");
		}
	}
}
