import java.util.Scanner;

public class task16 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		int m= scan.nextInt();
if(n<10|| n>5555 ||m<10 || m>5555){
	System.out.println("Invalid numbers");
}else{
	if(n<m){
		for(int num=m;num>=n;num--){
			if(num%50!=0){
				continue;
			}
			System.out.print(num + " ");
		}
	}else{
		for(int num1=n;num1>=m;num1--){
			if(num1%50!=0){
				continue;
			}
			System.out.print(num1 + " ");
		}
		if(n==m){
			System.out.print("Chislata sa ravni" + " ");
			
	}
	}
	}
	
	
}

	}


