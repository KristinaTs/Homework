import java.util.Scanner;

public class task21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cardNum = scan.nextInt();
		String strenght = "2";
		String color = "спатия";
		if (cardNum > 0 && cardNum <= 52) {
			for (int i = cardNum; i <= 52; i++) {
				int temp = i;
				switch (temp % 4) {
				case 1:
					color = "Спатия, ";
					break;
				case 2:
					color = "Каро, ";
					break;
				case 3:
					color = "Купа, ";
					break;
				case 0:
					color = "Пика, ";
					break;
				}
				switch (((temp - 1) / 4) + 2) {
				case 2:
					strenght = "2 ";
					break;
				case 3:
					strenght = "3 ";
					break;
				case 4:
					strenght = "4 ";
					break;
				case 5:
					strenght = "5 ";
					break;
				case 6:
					strenght = "6 ";
					break;
				case 7:
					strenght = "7 ";
					break;
				case 8:
					strenght = "8 ";
					break;
				case 9:
					strenght = "9 ";
					break;
				case 10:
					strenght = "10 ";
					break;
				case 11:
					strenght = "J ";
					break;
				case 12:
					strenght = "Q ";
					break;
				case 13:
					strenght = "K ";
					break;
				case 14:
					strenght = "А ";
					break;
				}
				System.out.println(strenght + color);
			}
		} else {
			System.out.println("Invalid number");
		}
	}
}


	


