package _02MultidimensionalArrays._02Exercise;

import java.util.Scanner;

public class _01FillMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] inputArr = scanner.nextLine().split(", ");
		int n = Integer.parseInt(inputArr[0]);
		char pattern = inputArr[1].charAt(0);
		int[][] matrix = new int[n][n];

		if(Character.toUpperCase(pattern) == 'A') {
			matrix = patternABest(n);
		} else if(Character.toUpperCase(pattern) == 'B') {
			matrix = patternBBest(n);
		}

		printMatrix(matrix);
	}

	private static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

	private static int[][] patternABest(int n) {
		int[][] matrix = new int[n][n];
		int num = 0;

		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n; row++) {
				matrix[row][col] = ++num;
			}
		}

		return matrix;
	}

	private static int[][] patternBBest(int n) {
		int[][] matrix = new int[n][n];
		int num = 0;

		for (int col = 0; col < n; col++) {
			for (int row = 0; row < n;) {
				if(col % 2 == 0) {
					matrix[row++][col] = ++num;
				} else {
					matrix[n - row++ - 1][col] = ++num;
				}
			}
		}

		return matrix;
	}

	private static int[][] patternA(int n) {
		int[][] matrix = new int[n][n];

		int col = 0;
		int num = 1;
		for (int i = 0; i < n && col < n;) {
			for (int j = 0; j < n; j++) {
				matrix[i++][col] = num++;
			}
			i = 0;
			col++;
		}

		return matrix;
	}

	private static int[][] patternB(int n) {
		int[][] matrix = new int[n][n];

		int col = 0;
		int num = 1;
		for (int i = 0; i < n && col < n;) {
			for (int j = 0; j < n; j++) {
				if(col % 2 == 0) {
					matrix[i++][col] = num++;
				} else {
					matrix[n - (i++) - 1][col] = num++;
				}
			}

			i = 0;
			col++;
		}

		return matrix;
	}
}
