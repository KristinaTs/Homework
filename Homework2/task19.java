import java.util.Scanner;

public class task19 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();		
		int temp;
		if(n<10 ||n>99){
			System.out.println("Invalid Number");
		}
		else{
			while(n>1){
				temp=n;
				if(n%2==0){
					n=n/2;
				}
				if(n%2!=0){
					n=3*n+1;
				}
				System.out.print(n+ " ");
				
			}
			
		}
		 
	}
}
			
		
				
				
			
		
	



