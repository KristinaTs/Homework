
import java.util.Scanner;

public class task22 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();	
		
		int i =n+1; 
		int j=1;
		while(j<=10){
			if(i%2==0 || i%3==0 || i%5==0){
				System.out.println(j + " "+ i);
				i++;
				j++;
				}
						
		
			
			else{
			i++;
			}
			
			
			
			
		}
		
		
	}

}