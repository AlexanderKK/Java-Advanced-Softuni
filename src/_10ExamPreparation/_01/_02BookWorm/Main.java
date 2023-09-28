package _10ExamPreparation._01._02BookWorm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. Initial String
        //2. Declare NxN matrix
        //3. Fill matrix
        //4. Until END receive commands for movement
        //5. Get position of letter P
        //6. up -> move P to [r - 1,c]
        //   down -> move P to [r + 1,c]
        //   right -> move P to [r, c + 1]
        //   left -> move P to [r, c - 1]
        //7. Save value of letter to a var and append to string and remove letter from matrix
        //8. If P goes out of matrix boundaries -> remove last letter from string and keep current position

        StringBuilder str = new StringBuilder(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String row = scanner.nextLine();

            for (int j = 0; j < row.length(); j++) {
                matrix[i][j] = row.charAt(j);
            }
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < matrix.length; i++) {
            boolean isFound = false;

            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'P') {
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

        String command;
        while(!"end".equals(command = scanner.nextLine())) {
            matrix[row][col] = '-';

            if(command.equals("up")) {
                row--;

                if(areIndicesValid(row, col, matrix)) {
                    appendToStr(str, row, col, matrix);
                } else {
                    row = 0;

                    removeLastLetter(str);
                }
            } else if(command.equals("down")) {
                row++;

                if(areIndicesValid(row, col, matrix)) {
                    appendToStr(str, row, col, matrix);
                } else {
                    row = matrix.length - 1;
                    removeLastLetter(str);
                }
            } else if(command.equals("left")) {
                col--;

                if(areIndicesValid(row, col, matrix)) {
                    appendToStr(str, row, col, matrix);
                } else {
                    col = 0;
                    removeLastLetter(str);
                }
            } else if(command.equals("right")) {
                col++;

                if(areIndicesValid(row, col, matrix)) {
                    appendToStr(str, row, col, matrix);
                } else {
                    col = matrix[0].length - 1;
                    removeLastLetter(str);
                }
            }

            matrix[row][col] = 'P';
        }

        printStringAndMatrix(str, matrix);
    }

    private static void printStringAndMatrix(StringBuilder str, char[][] matrix) {
        System.out.println(str);

        for (char[] r : matrix) {
            for (char value : r) {
                System.out.print(value);
            }

            System.out.println();
        }
    }

    private static void removeLastLetter(StringBuilder str) {
        if(str.length() > 0) {
            str.replace(str.length() - 1, str.length(), "");
        }
    }

    private static void appendToStr(StringBuilder str, int row, int col, char[][] matrix) {
        char token = matrix[row][col];

        if(token != '-') {
            str.append(token);
        }

        matrix[row][col] = '-';
    }

    private static boolean areIndicesValid(int row, int col, char[][] matrix) {
        return row <= matrix.length - 1 && row >= 0 && col >= 0 && col <= matrix[0].length - 1;
    }
}
