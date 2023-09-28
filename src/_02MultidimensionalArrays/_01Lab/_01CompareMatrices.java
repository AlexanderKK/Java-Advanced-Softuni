package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _01CompareMatrices {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int rows = Integer.parseInt(scanner.nextLine().split(" ")[0]);
		int[][] matrix1 = new int[rows][];

		for (int row = 0; row < rows; row++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

			matrix1[row] = rowValues;
		}

		rows = Integer.parseInt(scanner.nextLine().split(" ")[0]);
		int[][] matrix2 = new int[rows][];

		for (int row = 0; row < rows; row++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

			matrix2[row] = rowValues;
		}

		if(areMatricesEqual(matrix1, matrix2)) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
	}

	private static boolean areMatricesEqual(int[][] firstMatrix, int[][] secondMatrix) {

		//Check if matrices lengths are different
		if(firstMatrix.length != secondMatrix.length) {
			return false;
		}

		for (int row = 0; row < firstMatrix.length; row++) {

			//Check if matrices rows lengths are different
			if(firstMatrix[row].length != secondMatrix[row].length) {
				return false;
			}

			for (int col = 0; col < firstMatrix[row].length; col++) {

				//Check if matrices row values are different
				if(firstMatrix[row][col] != secondMatrix[row][col]) {
					return false;
				}
			}
		}

		return true;
	}
}
