import java.util.Scanner;

public class task17 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		char ch= scan.next().charAt(0);
		
		
		for(int i =1; i<=n;i++){
			System.out.print("*");
		}
		System.out.println();
		for(int row=2;row<=n-1;row++){
		System.out.print("*");
		for(int j = 2; j<=n-1;j++){
			System.out.print(ch);
		}
		System.out.print("*");
		System.out.println();
		}
		
		for(int i =1; i<=n;i++){
			System.out.print("*");
		}
		
	}

}
