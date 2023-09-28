package _11Exam._02MouseInTheKitchen;

import java.util.Arrays;
import java.util.Currency;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static int mouseRow;
    public static int mouseCol;
    public static int cheese;
    public static String message;

    public static void main(String[] args) {
        //1. Read rows and fillMatrix
        //2. Create while loop for direction commands
        //3. Get initial position of mouse
        //4. If next token is T, or it is out of boundaries of matrix -> end program
        //5. If next token is C -> eat cheese

        int rows = Integer.parseInt(String.valueOf(scanner.nextLine().charAt(0)));

        char[][] matrix = readMatrix(rows);

        String cmd;
        while(!"danger".equals(cmd = scanner.nextLine())) {
            if(cmd.equals("up")) {
                moveMouse(matrix, mouseRow - 1, mouseCol);
            } else if(cmd.equals("down")) {
                moveMouse(matrix, mouseRow + 1, mouseCol);
            } else if(cmd.equals("left")) {
                moveMouse(matrix, mouseRow, mouseCol - 1);
            } else if(cmd.equals("right")) {
                moveMouse(matrix, mouseRow, mouseCol + 1);
            }

            if(message != null) {
                break;
            }
        }

        System.out.println(Objects.requireNonNullElse(message, "Mouse will come back later!"));

        printMatrix(matrix);
    }

    private static void moveMouse(char[][] matrix, int nextRow, int nextCol) {
        if(isOutOfBounds(matrix, nextRow, nextCol)) {
            message = "No more cheese for tonight!";
        } else if(matrix[nextRow][nextCol] == 'T') {
            changeMousePosition(matrix, nextRow, nextCol);

            message = "Mouse is trapped!";
        } else if("C*".contains(matrix[nextRow][nextCol] + "")) {
            if(matrix[nextRow][nextCol] == 'C') {
                cheese--;
            }

            changeMousePosition(matrix, nextRow, nextCol);

            if(cheese == 0) {
                message = "Happy mouse! All the cheese is eaten, good night!";
            }
        }
    }

    private static void changeMousePosition(char[][] matrix, int nextRow, int nextCol) {
        matrix[mouseRow][mouseCol] = '*';
        matrix[nextRow][nextCol] = 'M';

        mouseRow = nextRow;
        mouseCol = nextCol;
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[row].length - 1;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows) {
        char[][] resultMatrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            String currentRow = scanner.nextLine();

            if(currentRow.contains("M")) {
                mouseRow = row;
                mouseCol = currentRow.indexOf("M");
            }

            int cheeseOnCurrentRow = (int) Arrays.stream(currentRow.split("")).filter(c -> c.equals("C")).count();
            cheese += cheeseOnCurrentRow;

            resultMatrix[row] = currentRow.toCharArray();
        }

        return resultMatrix;
    }
}
