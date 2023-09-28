package _02MultidimensionalArrays._02Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _05MatrixShuffling {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int rows = dimensions[0];
		int cols = dimensions[1];

		Object[][] matrix = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {
			Object[] rowValues = scanner.nextLine().split(" ");

			for (int j = 0; j < cols; j++) {
				matrix[i][j] = rowValues[j];
			}
		}

		String input;
		while(!(input = scanner.nextLine()).equals("END")) {
			if(!validateCommand(input, rows, cols)) {
				System.out.println("Invalid input!");
			} else {
				String indices = input.substring(input.indexOf(" ") + 1);
				int[] positions = Arrays.stream(indices.split(" ")).mapToInt(Integer::parseInt).toArray();

				swapElements(positions, matrix);

			}
		}
	}

	private static void swapElements(int[] positions, Object[][] matrix) {
		int row1 = positions[0];
		int col1 = positions[1];
		int row2 = positions[2];
		int col2 = positions[3];

		Object firstElement = matrix[row1][col1];
		matrix[row1][col1] = matrix[row2][col2];
		matrix[row2][col2] = firstElement;

		printMatrix(matrix);
	}

	private static void printMatrix(Object[][] matrix) {
		for (Object[] rowElements : matrix) {
			for (Object cellValue : rowElements) {
				System.out.print(cellValue + " ");
			}
			System.out.println();
		}
	}

	private static boolean validateCommand(String command, int rows, int cols) {
		String[] commandParts = command.split("\\s+");

		//Check if command does not start with swap
		if(!command.startsWith("swap")) {
			return false;
		}

		//Check if command does not have more than 4 positions
		if(commandParts.length != 5) {
			return false;
		}

		//Check if the 4 positions are valid
		int row1 = Integer.parseInt(commandParts[1]);
		int col1 = Integer.parseInt(commandParts[2]);
		int row2 = Integer.parseInt(commandParts[3]);
		int col2 = Integer.parseInt(commandParts[4]);

		if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
			return false;
		}

		return true;
	}
}
