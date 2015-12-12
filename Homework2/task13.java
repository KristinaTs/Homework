import java.util.Scanner;

public class task13 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int sum = scan.nextInt();
	if(sum<2 || sum>26){
		System.out.println("Invalid sum");
	}else{
		for(int num=100;num<=999;num++){
			int firstDigit=num/100;
			int secondDigit=(num/10)%10;
			int thirtDigit=num%10;
			if(firstDigit+secondDigit+thirtDigit!=sum){
				continue;
			}
			System.out.print(num + " ");

	}
	}
	}
}
