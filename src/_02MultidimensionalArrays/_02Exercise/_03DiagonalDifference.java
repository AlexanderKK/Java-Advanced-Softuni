package _02MultidimensionalArrays._02Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _03DiagonalDifference {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		int[][] matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			int[] row = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			matrix[i] = row;
		}

		int primaryDiagonal = 0;
		int secondaryDiagonal = 0;

		for (int index = 0; index < matrix.length; index++) {
			primaryDiagonal += matrix[index][index];
		}

		for (int row = n - 1, col = 0; row >= 0 && col < n; row--, col++) {
			secondaryDiagonal += matrix[row][col];
		}

		System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
	}
}
