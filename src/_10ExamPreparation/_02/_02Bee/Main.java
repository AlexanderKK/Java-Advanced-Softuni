package _10ExamPreparation._02._02Bee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillMatrix(scanner, n);

        int[] initialPositions = getPositions(matrix);

        int row = initialPositions[0];
        int col = initialPositions[1];

        boolean isOutOfTerritory = false;
        int pollinatedFlowers = 0;

        String command;
        while(!"End".equals(command = scanner.nextLine())) {
            matrix[row][col] = '.';

            if(command.equals("up")) {
                row--;

                if(row >= 0 && matrix[row][col] == 'O') {
                    matrix[row][col] = '.';
                    row--;
                }
            } else if(command.equals("down")) {
                row++;

                if(row < matrix.length && matrix[row][col] == 'O') {
                    matrix[row][col] = '.';
                    row++;
                }
            } else if(command.equals("left")) {
                col--;

                if(col >= 0 && matrix[row][col] == 'O') {
                    matrix[row][col] = '.';
                    col--;
                }
            } else if(command.equals("right")) {
                col++;

                if(col < matrix[0].length && matrix[row][col] == 'O') {
                    matrix[row][col] = '.';
                    col++;
                }
            }

            if(outOfTerritory(matrix, row, col)) {
                isOutOfTerritory = true;
                break;
            }

            if(matrix[row][col] == 'f') {
                pollinatedFlowers++;
            }

            matrix[row][col] = 'B';
        }

        printMatrixStats(matrix, isOutOfTerritory, pollinatedFlowers);
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            char[] line = scanner.nextLine().toCharArray();

            for (int col = 0; col < line.length; col++) {
                char token = line[col];

                matrix[row][col] = token;
            }
        }
        return matrix;
    }

    private static void printMatrixStats(char[][] matrix, boolean isOutOfTerritory, int pollinatedFlowers) {
        if(isOutOfTerritory) {
            System.out.println("The bee got lost!");
        }

        if(pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        }

        for (char[] tokens : matrix) {
            for (char token : tokens) {
                System.out.print(token);
            }
            System.out.println();
        }
    }

    private static boolean outOfTerritory(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length;
    }

    private static int[] getPositions(char[][] matrix) {
        int row = -1, col = -1;

        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;

            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 'B') {
                    row = i;
                    col = j;
                    isFound = true;
                    break;
                }
            }

            if(isFound) {
                break;
            }
        }

        return new int [] {row, col};
    }
}
