package _02MultidimensionalArrays._02Exercise;

import java.util.Scanner;

public class _01FillMatrix2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);
        char method = input[1].charAt(0);

        int[][] matrix = new int[n][n];

        if(Character.toUpperCase(method) == 'A') {
            int num = 1;

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = num++;
                }
            }
        } else if(Character.toUpperCase(method) == 'B') {
            int num = 1;

            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n;) {
                    if(col % 2 == 0) {
                        matrix[row++][col] = num++;
                    } else {
                        matrix[n - 1 - row++][col] = num++;
                    }
                }
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rowValues : matrix) {
            for (int colValue : rowValues) {
                System.out.print(colValue + " ");
            }
            System.out.println();
        }
    }
}
