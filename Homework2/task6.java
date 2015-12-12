import java.util.Scanner;

public class task6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете число");
		int num = scan.nextInt();
		int sum = 0;
		for (int i=num; i>=1;i-- ){
			sum+=i;
		}
		System.out.println(sum);
	}

}
