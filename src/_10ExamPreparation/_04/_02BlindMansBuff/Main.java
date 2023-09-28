package _10ExamPreparation._04._02BlindMansBuff;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static int row;
    public static int col;

    public static int opponentsTouched = 0;
    public static int movesCount = 0;

    public static void main(String[] args) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //Fill matrix and get start position of player
        char[][] matrix = fillMatrix(dimensions);

        String command;
        while(!"Finish".equals(command = scanner.nextLine())) {
            //Move player depending on direction
            if(command.equals("up")) {
                movePlayer(matrix, row - 1, col);
            } else if(command.equals("down")) {
                movePlayer(matrix, row + 1, col);
            } else if(command.equals("left")) {
                movePlayer(matrix, row, col - 1);
            } else if(command.equals("right")) {
                movePlayer(matrix, row, col + 1);
            }

            if(opponentsTouched == 3) {
                break;
            }
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d ", opponentsTouched);
        System.out.printf("Moves made: %d%n", movesCount);
    }

    private static boolean isOutOfBoundaries(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    private static void movePlayer(char[][] matrix, int nextRow, int nextCol) {
        if(!isOutOfBoundaries(matrix, nextRow, nextCol) && "P-".contains(matrix[nextRow][nextCol] + "")) {
            movesCount++;

            if(matrix[nextRow][nextCol] == 'P') {
                opponentsTouched++;
            }

            matrix[row][col] = '-';
            matrix[nextRow][nextCol] = 'B';

            row = nextRow;
            col = nextCol;
        }
    }

    private static char[][] fillMatrix(int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String rowValues = scanner.nextLine().replace(" ", "");

            if(rowValues.contains("B")) {
                row = i;
                col = rowValues.indexOf("B");
            }

            matrix[i] = rowValues.toCharArray();
        }

        return matrix;
    }
}
