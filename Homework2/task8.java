import java.util.Scanner;

public class task8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int num=n-1;
		int mn =1;
		int j=2; 
		while(j<=n){
			mn=mn*10+1;
			j++;
			}
		System.out.println(mn);

		int i=1;
		while(i<=n){
			int ch=num*mn;
			
			num+=2;
			i++;
			System.out.println(ch);
		}

	}

}
