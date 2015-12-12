import java.util.Scanner;

public class task10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num= scan.nextInt();
		boolean isPrime=true; 
		for(int i=2; i<num;i++){
			if(num%i==0){
				isPrime=false;
			}
		}
		if(isPrime==true){
			System.out.println("The number "+ num + " is prime");
		}
		else{
			System.out.println("The number "+ num + " is not prime");
		}

	}

}
