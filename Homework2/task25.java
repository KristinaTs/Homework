import java.util.Scanner;

public class task25 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sub=1; 
		int i=0;
		
		do{
			sub*=(n-i);
			i++;
		}
		while(i<n);
		System.out.println(sub);
		
		

	}

}
