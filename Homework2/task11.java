import java.util.Scanner;

public class task11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
	
		for(int i =1;i<=n;i++){
			for(int k=n-1; k>=i;k--){
				System.out.print(" ");
			}
			for(int j=1;j<=2*i-1;j++){
				
				System.out.print("*");
				
			}
			System.out.println();
		}
		
	}
}


