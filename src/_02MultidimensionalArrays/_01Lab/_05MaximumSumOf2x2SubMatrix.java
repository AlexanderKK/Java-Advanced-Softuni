package _02MultidimensionalArrays._01Lab;

import java.util.Arrays;
import java.util.Scanner;

public class _05MaximumSumOf2x2SubMatrix {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		//Get dimensions and read matrix input
		int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
		int[][] matrix = matrixReader(dimensions);

		//Declare rows and cols variables
		int row, col, i = 0, j = 0;

		//Declare SubMatrix
		int[][] subMatrix = new int[2][2];
		int subRow = 0, subCol = 0;

		int sum = 0;
		int counter = 0;

		//Declare max and biggestSubMatrix variables
		int max = Integer.MIN_VALUE;
		int[][] biggestSubMatrix = new int[2][2];

		for (row = i; row < matrix.length; row++) {
			for (col = j; col < matrix[row].length; col++) {
				if(subCol > 1) {   //Add up to 2 values per row in sub matrix
					break;
				}

				//Add to sub matrix
				subMatrix[subRow][subCol] = matrix[row][col];
				subCol++;

				//Count elements in sub matrix
				counter++;
			}

			//Refresh row and col index for sub matrix
			subRow++;
			subCol -= 2;

			//If sub matrix is filled, sum elements and get max sum. Also get biggest sub matrix
			if(counter == 4) {
				for (int[] numArr : subMatrix) {
					for (int num : numArr) {
						sum += num;
					}
				}

				if(sum > max) {
					max = sum;   //Set max sum
					biggestSubMatrix = Arrays.copyOf(subMatrix, 2);   //Set biggest sub matrix
					subMatrix = new int[2][2];   //Initialize new SubMatrix
				}

				//Reset sum, counter row and col indexes for sub matrix and go to next column in matrix
				sum = 0;
				counter = 0;
				subRow = 0;
				subCol = 0;
				j++;

				//If last - 1 col and last - 1 row is reached -> exit loop | otherwise go to next line and start again
				if(j == matrix[0].length - 1 && row == matrix.length - 1) {
					break;
				} else if(j == matrix[0].length - 1) {
					row++;
					j = 0;
				}

				row -= 2;
			}
		}

		//Print biggest sub matrix elements
		printBiggestSubMatrix(max, biggestSubMatrix);
	}

	private static void printBiggestSubMatrix(int max, int[][] biggestSubMatrix) {
		for (int[] rowValues : biggestSubMatrix) {
			for (int value : rowValues) {
				System.out.print(value + " ");
			}
			System.out.println();
		}

		//Print max sum
		System.out.println(max);
	}

	public static int[][] matrixReader(int[] dimensions) {
		int rows = dimensions[0];
		int cols = dimensions[1];

		int[][] matrix = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			int[] rowValues = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

			for (int j = 0; j < cols; j++) {
				matrix[i][j] = rowValues[j];
			}
		}
		return matrix;
	}
}
