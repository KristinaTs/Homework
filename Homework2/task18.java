import java.util.Scanner;

public class task18 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int a= scan.nextInt();
		int b= scan.nextInt();
	
		if(a<0||a>9||b<0||b>9){
			System.out.println("Invalid numbers");
		}else{
		for(int i =1; i<=a;i++){
			for(int j=1;j<=b;j++){
				int um=i*j;
				System.out.println(i +"* "+ j + "= "+ um);
				}
		
		
		}

	}

	}
}
