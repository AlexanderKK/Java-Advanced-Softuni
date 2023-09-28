package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _08WrongMeasurements {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//1. Чета редове на матрица и елементи на матрица
		//2. Търся елемента на позиция x & y
		//3. Щом го намеря взимам елементите под, над, отляво и отдясно на него и ги сумирам
		//4. Замествам конкретния елемент със сумата от съседните
		//5. След това преминавам на следващия елемент и пращя същото нещо до края на матрицата
		//6. Връщам матрицата в новия и вид

		//1.
		int rowsInput = Integer.parseInt(scanner.nextLine());
		int[][] matrix = new int[rowsInput][];

		for (int i = 0; i < rowsInput; i++) {
			int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			matrix[i] = elements;
		}

		//2.
		int[] positions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int posRow = positions[0];
		int posCol = positions[1];


		int wrongValue = matrix[posRow][posCol];

		//3.
		int[][] newMatrix = new int[matrix.length][matrix[0].length];

		int rows = matrix.length;
		for (int i = 0; i < rows; i++) {
			int cols = matrix[i].length;

			for (int j = 0; j < cols; j++) {
				if(matrix[i][j] == wrongValue) {
					newMatrix[i][j] = getSum(matrix, wrongValue, i, j);
				} else {
					newMatrix[i][j] = matrix[i][j];
				}
			}
		}

		printMatrix(newMatrix);
	}

	private static void printMatrix(int[][] newMatrix) {
		for (int[] row : newMatrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

	private static int getSum(int[][] matrix, int wrongValue, int i, int j) {
		int sum = 0;

		//Sum left element
		int left = j - 1;
		if(left >= 0) {
			if(matrix[i][left] != wrongValue) {
				sum += matrix[i][left];
			}
		}

		//Sum top element
		int top = i - 1;
		if(top >= 0) {
			if(matrix[top][j] != wrongValue) {
				sum += matrix[top][j];
			}
		}

		//Sum right element
		int right = j + 1;
		if(right <= matrix[i].length - 1) {
			if(matrix[i][right] != wrongValue) {
				sum += matrix[i][right];
			}
		}

		//Sum bottom element
		int bottom = i + 1;
		if(bottom <= matrix.length - 1) {
			if(matrix[bottom][j] != wrongValue) {
				sum += matrix[bottom][j];
			}
		}
		return sum;
	}
}
