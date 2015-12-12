import java.util.Scanner;

public class task11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [7];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<7;index++){
			arr[index]=scan.nextInt();
		}
		 int sum=0;
		for(int index=0; index<arr.length;index++){
			if(arr[index]>5 && arr[index]%5==0){
				sum++;
				System.out.print(arr[index]+ " ");
			}
		}
		
		if(sum==1){
			System.out.println(" 1 числo");

		}
		else{
		System.out.println(sum + " числа");
		}

	}

}
