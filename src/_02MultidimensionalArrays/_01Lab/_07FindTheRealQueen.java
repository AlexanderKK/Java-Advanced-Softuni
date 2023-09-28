package _02MultidimensionalArrays._01Lab;

import java.util.Scanner;

public class _07FindTheRealQueen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		char[][] chessboard = new char[8][8];

		for (int i = 0; i < 8; i++) {
			chessboard[i] = scanner.nextLine().replace(" ", "").toCharArray();
		}

		boolean isQueenValid = false;
		int posRow = -1;
		int posCol = -1;

		for (int row = 0; row < chessboard.length; row++) {
			for (int col = 0; col < chessboard[row].length; col++) {
				if(chessboard[row][col] == 'q') {
					//Check for valid queen
					isQueenValid = checkValidQueen(chessboard, row, col);

					//If queen is valid get its position and exit loop
					if(isQueenValid) {
						posRow = row;
						posCol = col;

						break;
					}
				}
			}

			if(isQueenValid) {
				break;
			}
		}

		if(isQueenValid) {
			System.out.print(posRow + " " + posCol);
		}
	}

	private static boolean checkValidQueen(char[][] chessboard, int row, int col) {
		//Check if q present on vertical line
		for (int i = 0; i < chessboard.length; i++) {
			if(i != row && chessboard[i][col] == 'q') {
				return false;
			}
		}

		//Check if q present on horizontal line
		for (int i = 0; i < chessboard[row].length; i++) {
			if(i != col && chessboard[row][i] == 'q') {
				return false;
			}
		}

		//Check if present on first diagonal

		//Elements before current 'q' on first diagonal - From q to Top Left
		int i = row - 1, j = col - 1;

		while(i >= 0 && j >= 0) {
			if(chessboard[i][j] == 'q') {
				return false;
			}

			i--;
			j--;
		}

		//Elements after current 'q' on first diagonal - From q to Bottom Right
		i = row + 1;
		j = col + 1;

		while(i < chessboard.length && j < chessboard[0].length) {
			if(chessboard[i][j] == 'q') {
				return false;
			}

			i++;
			j++;
		}

		//Check if present on second diagonal

		//Elements before current 'q' on second diagonal - From q to Bottom Left
		i = row + 1;
		j = col - 1;

		while(i < chessboard.length && j >= 0) {
			if(chessboard[i][j] == 'q') {
				return false;
			}

			i++;
			j--;
		}

		//Elements after current 'q' on second diagonal - From q to Top Right
		i = row - 1;
		j = col + 1;

		while(i >= 0 && j < chessboard[0].length) {
			if(chessboard[i][j] == 'q') {
				return false;
			}

			i--;
			j++;
		}

		return true;
	}
}
