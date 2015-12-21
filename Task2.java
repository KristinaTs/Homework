import java.util.Scanner;

public class Task2 {

	static boolean gameCondition(char[][] newBoard) {
		for (int row = 0; row < 3; row++) {

			if ((newBoard[row][0] == newBoard[row][1]) && (newBoard[row][1] == newBoard[row][2])) {
				if (newBoard[row][0] != ' ') {
					return false;
				}
			}
			if ((newBoard[0][row] == newBoard[1][row]) && (newBoard[1][row] == newBoard[2][row])) {
				if (newBoard[0][row] != ' ') {
					return false;
				}
			}
		}

		if ((newBoard[0][0] == newBoard[1][1]) && (newBoard[1][1] == newBoard[2][2])) {
			if (newBoard[0][0] != ' ') {
				return false;
			}
		}
		if ((newBoard[0][2] == newBoard[1][1]) && (newBoard[1][1] == newBoard[2][0])) {
			if (newBoard[0][2] != ' ') {
				return false;
			}
		}
		return true;
	}

	static void print(char[][] newBoard) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (col == 1) {
					System.out.print(newBoard[row][col]);
				} else {
					System.out.print("|" + newBoard[row][col] + "|");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// char[][] board = new char[3][3];
		char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		int i = 1;
		int tie = 0;
		Scanner sc = new Scanner(System.in);
		while (gameCondition(board)) {
			print(board);
			System.out.print(i + ":");
			int first = sc.nextInt();
			int second = sc.nextInt();
			if (first > 3 || first < 1 || second > 3 || second < 1) {
				System.out.println("Invalid coordinates");
				continue;
			}
			first--;
			second--;
			if ((board[first][second] == 'X') || (board[first][second] == 'O')) {
				System.out.println("Invalid coordinates");
				continue;
			}
			if (i == 1) {
				board[first][second] = 'X';
				i = 2;
				tie++;
				if (tie == 9) {
					i = 3;
					break;
				}
				continue;
			}
			if (i == 2) {
				tie++;
				if (tie == 9) {
					i = 3;
					break;
				}
				board[first][second] = 'O';
				i = 1;
			}
		}
		if (i == 1) {
			System.out.println("Player two wins");
		}
		if (i == 2) {
			System.out.println("Player one wins");
		}
		if (i == 3) {
			System.out.println("Tie!");
		}
		print(board);

	}

}
