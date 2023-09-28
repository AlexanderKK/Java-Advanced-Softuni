package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _04SumMatrixElements {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[][] matrix = matrixReader(dimensions);

		int sum = 0;
		for (int[] numbers : matrix) {
			for (int number : numbers) {
				sum += number;
			}
		}

		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		System.out.println(sum);
	}

	protected static int[][] matrixReader(int[] dimensions) {
		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

			for (int j = 0; j < cols; j++) {
				matrix[i][j] = rowValues[j];
			}
		}
		return matrix;
	}
}
