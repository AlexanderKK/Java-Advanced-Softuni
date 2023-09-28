package _02MultidimensionalArrays._02Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _02MatrixOfPalindromes {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int rows = dimensions[0];
		int cols = dimensions[1];

		if(rows + cols <= 27) {
			String[][] palindromes = new String[rows][cols];

			char letterRow = 'a';
			char letterCol = 'a';

			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					String palindrome = "" + letterRow + letterCol + letterRow;
					palindromes[i][j] = palindrome;

					letterCol = (char)(letterCol + 1);
				}

				letterRow = (char)(letterRow + 1);
				letterCol = letterRow;
			}

			printMatrix(palindromes);
		}
	}

	private static void printMatrix(String[][] matrix) {
		for (String[] row : matrix) {
			for (String col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
}
