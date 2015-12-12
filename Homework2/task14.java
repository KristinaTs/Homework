import java.util.Scanner;

public class task14 {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		int n= scan.nextInt();
		
		if(n<10 || n>200){
			System.out.println("Invalid sum");
		}else{
			for(int num=n;num>=10;num--){
				if(num%7!=0){
					continue;
				}
				System.out.print(num + " ");
				
			}
		}

	}

}
