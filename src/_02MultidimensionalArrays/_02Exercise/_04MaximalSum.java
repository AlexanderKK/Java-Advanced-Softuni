package _02MultidimensionalArrays._02Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04MaximalSum {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//Get dimensions and read matrix input
		int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[][] matrix = matrixReader(dimensions);
		int maxSum = Integer.MIN_VALUE;
		int rowPos = 0;
		int colPos = 0;

		for (int row = 0; row < matrix.length - 2; row++) {
			for (int col = 0; col < matrix[col].length - 2; col++) {
				int sum = 0;
				//Sum elements in sub matrix
				for (int currentRow = row; currentRow < row + 3; currentRow++) {
					for (int currentCol = col; currentCol < col + 3; currentCol++) {
						sum += matrix[currentRow][currentCol];
					}
				}

				if(sum > maxSum) {
					maxSum = sum;
					rowPos = row;
					colPos = col;
				}
			}
		}

		printMatrix(matrix, maxSum, rowPos, colPos);
	}

	private static void printMatrix(int[][] matrix, int maxSum, int rowPos, int colPos) {
		System.out.printf("Sum = %d%n", maxSum);
		for (int row = rowPos; row < rowPos + 3; row++) {
			for (int col = colPos; col < colPos + 3; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] matrixReader(int[] dimensions) {
		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int j = 0; j < cols; j++) {
				matrix[i][j] = rowValues[j];
			}
		}
		return matrix;
	}
}
