import java.util.Scanner;

public class task12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [7];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<7;index++){
			arr[index]=scan.nextInt();
		}
		
		for(int index=0; index<arr.length;index=index+2){
			if(index==0){
				int temp=arr[1];
				arr[1]=arr[0];
				arr[0]=temp;
			}
			
			if(index==2){
				int sum=arr[2]+arr[3];
				arr[2]=sum-arr[2];
				arr[3]=sum-arr[3];
			}
			if(index==4){
				int mul=arr[4]*arr[5];
				arr[4]=mul/arr[4];
				arr[5]=mul/arr[5];
						}
		}
		
		for(int index1=0; index1<arr.length;index1++){
			System.out.print(arr[index1] + " ");
		}

	}

}
