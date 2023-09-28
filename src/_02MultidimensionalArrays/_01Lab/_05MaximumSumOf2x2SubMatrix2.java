package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05MaximumSumOf2x2SubMatrix2 {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//Get dimensions and read matrix input
		int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[][] matrix = matrixReader(dimensions);
		int maxSum = Integer.MIN_VALUE;

		int row = -1;
		int col = -1;

		for (int i = 0; i <= matrix.length - 2; i++) {
			for (int j = 0; j <= matrix[i].length - 2; j++) {
				int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

				if(sum > maxSum) {
					maxSum = sum;
					row = i;
					col = j;
				}
			}
		}

		printSubMatrixAndMaxSum(matrix, maxSum, row, col);
	}

	private static void printSubMatrixAndMaxSum(int[][] matrix, int maxSum, int row, int col) {
		for (int i = 1; i <= 4; i++) {
			System.out.print(matrix[row][col] + " ");
			col++;

			if(i == 2) {
				row++;
				col -= 2;

				System.out.println();
			}

		}
		System.out.println();
		System.out.println(maxSum);
	}

	private static int[][] matrixReader(int[] dimensions) {
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
