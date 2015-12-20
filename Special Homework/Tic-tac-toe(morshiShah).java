import java.util.Scanner;

public class game {

	static boolean isEmpty(char arr[][]) {
		boolean isEmpty = true;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (arr[row][col] != 0) {
					isEmpty = false;
				}
			}
		}
		return isEmpty;
	}

	static boolean endGame(char arr[][]) {
		boolean endGame = false;

		for (int col = 0; col < 3; col++) {
			if (arr[0][col] != '/' && arr[0][col] == arr[1][col] && arr[1][col] == arr[2][col]) {
				endGame = true;
			}
		}
		for (int row = 0; row < 3; row++) {
			if (arr[row][0] != '/' && arr[row][0] == arr[row][1] && arr[row][1] == arr[row][2]) {
				endGame = true;
			}
			if ((arr[0][0] != '/' && arr[0][0] == arr[1][1]) && (arr[1][1] == arr[2][2])) {
				endGame = true;
			}
			if (arr[2][0] != '/' && arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2]) {
				endGame = true;
			}
		}
		return endGame;
	}

	public static void main(String[] args) {
		int moves = 0;
		int winnerNum = 1;
		Scanner scan = new Scanner(System.in);
		char[][] arr = new char[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				arr[row][col] = '/';
			}
		}
		boolean endGame = endGame(arr);
		System.out.println(endGame);
		int row = 0;
		int col = 0;
		while (endGame != true && moves<9) {
			if (winnerNum == 1) {
				System.out.println("Player number 1:");
				System.out.println("Input coordinates");
				row = scan.nextInt();
				col = scan.nextInt();

			}
			if (winnerNum == 2) {
				System.out.println("Player number 2:");
				System.out.println("Input coordinates");
				row = scan.nextInt();
				col = scan.nextInt();
			}

			if (row < 0 || row > 3 || col < 0 || col > 3) {
				System.out.println("Invalid Coordinates");
				if (winnerNum == 1) {
					winnerNum = 1;
				} else {
					winnerNum = 2;
				}
				continue;
			} else {
				if (arr[row - 1][col - 1] == 'x' || arr[row - 1][col - 1] == 'o') {
					continue;
				}
				if (arr[row - 1][col - 1] == '/' && winnerNum == 1) {
					arr[row - 1][col - 1] = 'x';
					winnerNum = 2;
					moves++;
				}
				if (arr[row - 1][col - 1] == '/' && winnerNum == 2) {
					arr[row - 1][col - 1] = 'o';
					winnerNum = 1;
					moves++;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			endGame = endGame(arr);

		}
	if(winnerNum==2 && moves<9){
		System.out.println("The winner is player number 1!");
	}
	if(winnerNum==1&& moves<9){
		System.out.println("The winner is player number 2!");
	}
	if(moves==9){
		System.out.println("It is a tie!");
	}
		
	}

}


	

