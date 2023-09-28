package _00Olimpiada;

import java.util.Scanner;

public class _04Bombi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        //Input constraint
        if(rows < 2 || cols > 50) {
            return;
        }

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] inputLine = scanner.nextLine().toCharArray();

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = inputLine[j];
            }
        }

        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '*') {

                    for (int k = 0; k < matrix[i].length; k++) {
                        matrix[i][k] = '*';
                        counter++;
                    }

                }
            }

            if(counter == 2) {
                break;
            }
        }

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
