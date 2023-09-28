package _10ExamPreparation._03._02ReVolt;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static int playerRow;
    private static int playerCol;

    private static boolean hasWon = false;

    public static void main(String[] args) {
        int rows = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = matrixReader(new int[] {rows, rows});

        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();

            if(command.equals("up")) {
                movePlayer(matrix, -1, 0);
            } else if(command.equals("down")) {
                movePlayer(matrix, 1, 0);
            } else if(command.equals("left")) {
                movePlayer(matrix, 0, -1);
            } else if(command.equals("right")) {
                movePlayer(matrix, 0, 1);
            }

            //Exit Loop
            if(hasWon) {
                break;
            }
        }

//        if(hasWon) {
//            System.out.println("Player won!");
//        } else {
//            System.out.println("Player lost!");
//        }

//        System.out.println(hasWon ? "Player won!" : (playerRow == matrix.length - 1 ? "Row: " + playerRow : "Player lost!"));

//        var result = someBool ? "a" : (otherBool ? "b" : "c");

        System.out.println(hasWon ? "Player won!" : "Player lost!");
        printMatrix(matrix);
    }

    private static void movePlayer(char[][] matrix, int rowMutator, int colMutator) {
        int nextRow = playerRow + rowMutator;
        int nextCol = playerCol + colMutator;

        if(isOutOfBounds(matrix, nextRow, nextCol)) {
            if(nextRow < 0 || nextRow >= matrix.length) {
                nextRow = nextRow < 0 ? matrix.length - 1 : 0;
            } else {
                nextCol = nextCol < 0 ? matrix[nextRow].length - 1 : 0;
            }
        }

        if(matrix[nextRow][nextCol] == 'T') {
            return;
        } else if(matrix[nextRow][nextCol] == 'B') {
            matrix[playerRow][playerCol] = '-';
            playerRow = nextRow;
            playerCol = nextCol;

            movePlayer(matrix, rowMutator, colMutator);
            return;
        } else if(matrix[nextRow][nextCol] == 'F') {
            hasWon = true;
        }

        if(matrix[playerRow][playerCol] != 'B') {
            matrix[playerRow][playerCol] = '-';
        }
        matrix[nextRow][nextCol] = 'f';

        playerRow = nextRow;
        playerCol = nextCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int r, int c) {
        return r < 0 || r >= matrix.length || c < 0 || c >= matrix[r].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] tokens : matrix) {
            for (char token : tokens) {
                System.out.print(token);
            }
            System.out.println();
        }
    }

    protected static char[][] matrixReader(int[] dimensions) {
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String rowStr = scanner.nextLine();

            if(rowStr.contains("f")) {
                playerRow = row;
                playerCol = rowStr.indexOf("f");
            }
            matrix[row] = rowStr.toCharArray();

//            System.arraycopy(rowValues, 0, matrix[row], 0, cols);
        }
        return matrix;
    }
}
