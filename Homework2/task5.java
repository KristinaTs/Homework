import java.util.Scanner;

public class task5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете първото число");
		int a = scan.nextInt();
		System.out.println("Въведете второто число");
		int b = scan.nextInt();
		
		if (a<b){
			for (int i=a; i<=b;i++){
				System.out.print(i+ " ");
			}
		}	
		if(b<a){
			for(int j =b;j<=a;j++){
				System.out.print(j+ " ");
			}
		}
		if(a==b){
			System.out.println(a);
			
			
		}
		

	}

}
