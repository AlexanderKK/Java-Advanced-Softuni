package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _03IntersectionOfTwoMatrices {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine());
		int cols = Integer.parseInt(scanner.nextLine());

		char[][] matrix1 = new char[rows][];

		for (int row = 0; row < rows; row++) {
			char[] rowValues = scanner.nextLine().replace(" ", "").toCharArray();

			matrix1[row] = rowValues;
		}

		char[][] matrix2 = new char[rows][];

		for (int row = 0; row < rows; row++) {
			char[] rowValues = scanner.nextLine().replace(" ", "").toCharArray();

			matrix2[row] = rowValues;
		}

		char[][] result = intersectMatrices(matrix1, matrix2, rows, cols);
		printMatrix(result);
	}

	private static void printMatrix(char[][] matrix) {
		for (char[] charsArr : matrix) {
			for (char token : charsArr) {
				System.out.print(token + " ");
			}
			System.out.println();
		}
	}

	private static char[][] intersectMatrices(char[][] matrix1, char[][] matrix2, int rows, int cols) {
		char[][] resultMatrix = new char[rows][cols];

		for (int row = 0; row < matrix1.length; row++) {
			for (int col = 0; col < matrix1[row].length; col++) {
				if(matrix1[row][col] != matrix2[row][col]) {
					resultMatrix[row][col] = '*';
				} else {
					resultMatrix[row][col] = matrix1[row][col];
				}
			}
		}
		return resultMatrix;
	}
}
