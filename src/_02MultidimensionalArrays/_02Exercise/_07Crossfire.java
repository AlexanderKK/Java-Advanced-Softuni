package _02MultidimensionalArrays._02Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07Crossfire {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1.
		int[] inputArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int rows = inputArr[0];
		int cols = inputArr[1];
		if(rows >= 2 && rows <= 100 && cols >= 2 && cols <= 100) {
			int[][] matrix = new int [ rows ][ cols ];
			int num = 1;

			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					matrix[row][col] = num;
					num++;
				}
			}

			String command;
			while(!"Nuke it from orbit".equals(command = scanner.nextLine())) {
				String[] input = command.split(" ");

				int row = Integer.parseInt(input[0]);
				int col = Integer.parseInt(input[1]);
				int radius = Integer.parseInt(input[2]);

				if(row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix[0].length - 1) {
					//Remove element
					matrix[row][col] = 0;

					for (int i = 1; i <= radius; i++) {
						//Remove left element
						int left = col - i;
						if(left >= 0 && left < matrix[row].length) {
							matrix[row][left] = 0;
						}

						//Remove top element
						int top = row - i;
						if(top >= 0 && col < matrix[top].length) {
							matrix[top][col] = 0;
						}

						//Remove right element
						int right = col + i;
						if(right >= 0 && right <= matrix[row].length - 1) {
							matrix[row][right] = 0;
						}

						//Remove bottom element
						int bottom = row + i;
						if(bottom >= 0 && bottom <= matrix.length - 1 && col < matrix[bottom].length) {
							matrix[bottom][col] = 0;
						}
					}

					for (int rowPos = 0; rowPos < matrix.length; rowPos++) {
						matrix[rowPos] = removeElement(matrix[rowPos], 0);
					}
				} else {
					break;
				}
			}

			printMatrix(matrix);
		}
	}

	private static int[] removeElement(int[] arr, int number) {
		if (arr.length == 0) {
			return arr;
		}

		int decreaseFactor = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				decreaseFactor++;
			}
		}

		int length = arr.length - decreaseFactor;

		int[] anotherArray = new int[length];

		for (int i = 0, k = 0; i < arr.length; i++) {
			if (arr[i] == number) {
				continue;
			}

			anotherArray[k++] = arr[i];
		}

		return anotherArray;
	}

	private static void printMatrix(int[][] newMatrix) {
		for (int[] row : newMatrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}
