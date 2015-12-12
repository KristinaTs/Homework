import java.util.Scanner;

public class task24 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int num = scan.nextInt();
		int n = num;
		int newNum = 0;
		 boolean isPalidrome= false; 
		do
		 {
		     int  digit = num% 10;
		      newNum = newNum * 10 + digit;
		      num/=10;
		      if(n==newNum){
		    	  isPalidrome = true;
		      }
		 }
		 while (num > 0);
		if(isPalidrome == true ){
			System.out.println("The number "+ n + " is a palidrome");
		}
		else{
			System.out.println("The number "+ n+ " is a not palidrome");
		}
		

	}

}
