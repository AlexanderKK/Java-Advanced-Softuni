package _02MultidimensionalArrays._02Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06StringMatrixRotation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Pick degrees for rotation
		String rotation = scanner.nextLine();
		int degrees = Integer.parseInt(rotation.substring(rotation.indexOf("(") + 1, rotation.indexOf(")")));

		//Get a number of strings
		List<String> texts = new ArrayList<>();

		String input;
		while(!"END".equals(input = scanner.nextLine())) {
			texts.add(input);
		}

		int maxLength = 0;
		for (String text : texts) {
			if(text.length() > maxLength) {
				maxLength = text.length();
			}
		}

		int rows = texts.size();
		int cols = maxLength;

		char[][] matrix = fillMatrix(rows, cols, texts);

		if(degrees % 90 == 0) {
			char[][] rotatedMatrix = rotateMatrix(matrix, degrees);
			printMatrix(rotatedMatrix);
		}
	}

	private static char[][] rotateMatrix(char[][] matrix, int degreesInput) {
		char[][] resultMatrix;

		int degrees;
		int rotations = 0;

		degrees = degreesInput % 360;

		if(degreesInput == 270 || degrees == 270) {
			rotations = 3;
		} else if(degreesInput == 180 || degrees == 180) {
			rotations = 2;
		} else if(degreesInput == 90 || degrees == 90) {
			rotations = 1;
		}

		if(rotations % 2 == 0) {
			resultMatrix = new char[matrix.length][matrix[0].length];
		} else {
			resultMatrix = new char[matrix[0].length][matrix.length];
		}

		if(rotations == 0) {
			resultMatrix = matrix;
		} else {
			int r = 0, c = 0;

			if(rotations == 1) {
				//Loop through every column
				for (int col = 0; col < matrix[0].length; col++) {
					//Loop through every row
					for (int row = matrix.length - 1; row >= 0; row--) {
						resultMatrix[r][c] = matrix[row][col];

						c++;
					}
					r++;
					c = 0;
				}
			} else if(rotations == 2) {
				//Loop through every row
				for (int row = matrix.length - 1; row >= 0; row--) {
					//Loop through every column
					for (int col = matrix[0].length - 1; col >= 0; col--) {
						resultMatrix[r][c] = matrix[row][col];

						c++;
					}
					r++;
					c = 0;
				}
			} else {
				//Loop through every column
				for (int col = matrix[0].length - 1; col >= 0; col--) {
					//Loop through every row
					for (int row = 0; row < matrix.length; row++) {
						resultMatrix[r][c] = matrix[row][col];

						c++;
					}
					r++;
					c = 0;
				}
			}
		}

		return resultMatrix;
	}

	private static void printMatrix(char[][] matrix) {
		for (char[] charSequence : matrix) {
			for (char token : charSequence) {
				System.out.print(token);
			}
			System.out.println();
		}
	}

	private static char[][] fillMatrix(int rows, int cols, List<String> texts) {
		char[][] matrix = new char[rows][cols];

		for (int row = 0; row < rows; row++) {
			String text = texts.get(row);

			for (int col = 0; col < cols; col++) {
				if(col < text.length()) {
					matrix[row][col] = text.charAt(col);
				} else {
					matrix[row][col] = ' ';
				}
			}
		}
		return matrix;
	}
}
