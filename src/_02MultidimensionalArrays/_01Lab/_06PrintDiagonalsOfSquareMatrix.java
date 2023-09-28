package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _06PrintDiagonalsOfSquareMatrix {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = Integer.parseInt(scanner.nextLine());

		int[][] matrix = new int[n][];

		for (int i = 0; i < n; i++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			matrix[i] = rowValues;
		}

		//Get elements from first diagonal
		int row = 0, col = 0;
		while(row < matrix.length) {
			System.out.print(matrix[row][col] + " ");

			row++;
			col++;
		}

		System.out.println();

		//Get elements from second diagonal
		row = matrix.length - 1;
		col = 0;

		while(col < matrix[0].length) {
			System.out.print(matrix[row][col] + " ");

			row--;
			col++;
		}
	}
}
