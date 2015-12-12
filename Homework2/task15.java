import java.util.Scanner;



public class task15 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		int sum=0;
		int num=1;
		do{
			sum+=num;
			num++;
		}while(num<=n);
//		
		System.out.print(sum);
	}
	

}
