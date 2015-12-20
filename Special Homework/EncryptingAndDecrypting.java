
public class Code {

	static char[] encrypt(char[] arr) {
		char[][] table = { { 'A', 'B', 'C', 'D', 'E' }, { 'F', 'G', 'H', 'I', 'J' }, { 'K', 'L', 'M', 'N', 'O' },
				{ 'P', 'Q', 'R', 'S', 'T' }, { 'U', 'V', 'W', 'X', 'Y' }, };
		int size = arr.length;
		char[] newArr = new char[size];
		int row = 0;
		int col = 0;
		int row1 = 0;
		int col1 = 0;
		for (int index = 0; index < size; index += 2) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[index] == table[r][c]){
					row = r;
					col = c;
					}
					if (arr[index + 1] == table[r][c]){
					row1 = r;
					col1 = c;
					}
				}
			}
			if (row != row1 && col != col1) {
				newArr[index] = table[row][col1];
				newArr[index + 1] = table[row1][col];
			}
			if (row == row1) {
				if (col == 4) {
					newArr[index] = table[row][0];
				} else {
					newArr[index] = table[row][col + 1];
				}
				if (col1 == 4) {
					newArr[index + 1] = table[row][0];
				} else {
					newArr[index+1] = table[row1][col1 + 1];
				}
			}
			if (col == col1) {
				if (row == 4) {
					newArr[index] = table[0][col];
				} else {
					newArr[index] = table[row + 1][col];
				}
				if (row1 == 4) {
					newArr[index] = table[0][col1];
				} else {
					newArr[index+1] = table[row1 + 1][col1];
				}

			}

		}
		return newArr;
	}
	static char[] decrypt(char[] arr) {
		char[][] table = { { 'A', 'B', 'C', 'D', 'E' }, { 'F', 'G', 'H', 'I', 'J' }, { 'K', 'L', 'M', 'N', 'O' },
				{ 'P', 'Q', 'R', 'S', 'T' }, { 'U', 'V', 'W', 'X', 'Y' }, };
		int size = arr.length;
		char[] newArr = new char[size];
		int row = 0;
		int col = 0;
		int row1 = 0;
		int col1 = 0;
		for (int index = 0; index < size; index += 2) {
			for (int r = 0; r < 5; r++) {
				for (int c = 0; c < 5; c++) {
					if (arr[index] == table[r][c]){
					row = r;
					col = c;
					}
					if (arr[index + 1] == table[r][c]){
					row1 = r;
					col1 = c;
					}
				}
			}
			if (row != row1 && col != col1) {
				newArr[index] = table[row][col1];
				newArr[index + 1] = table[row1][col];
			}
			if (row == row1) {
				if (col == 0) {
					newArr[index] = table[row][4];
				} else {
					newArr[index] = table[row][col-1];
				}
				if (col1 == 0) {
					newArr[index + 1] = table[row][4];
				} else {
					newArr[index+1] = table[row1][col1-1];
				}
			}
			if (col == col1) {
				if (row == 0) {
					newArr[index] = table[4][col];
				} else {
					newArr[index] = table[row-1][col];
				}
				if (row1 == 0) {
					newArr[index] = table[4][col1];
				} else {
					newArr[index+1] = table[row1-1][col1];
				}

			}

		}
		return newArr;
	}
	public static void main(String[] args) {
		String str="aaaaaa";
		if(str.length()%2!=0){
		str=str+'a';
		}
		String strBig=str.toUpperCase();
		char[] arr = strBig.toCharArray();
for(int i=0;i<arr.length;i++){
	System.out.print(arr[i]+ " ");
}
	char [] newArr=encrypt(arr);
	char [] de = decrypt(newArr);
	System.out.println();
	for(int i=0;i<arr.length;i++){
		System.out.print(newArr[i]+ " ");
	}
	System.out.println();
	for(int i=0;i<arr.length;i++){
		System.out.print(de[i]+ " ");
	}
	}
}
