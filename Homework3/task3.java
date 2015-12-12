import java.util.Scanner;

public class task3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		int []arr = new int[10];
		arr[0]=number;
		arr[1]=number;
		int i=2;
		while(i<=9){
			arr[i]=arr[i-1]+arr[i-2];
			i++;
		}
		
		
		for(int index=0; index<arr.length;index++){
			System.out.println(arr[index] + " ");
		}
	}

}
