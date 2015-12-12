import java.util.Scanner;

public class task13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num=scan.nextInt();
		int n=num;
		int n1=num;
		
		int sum=0;
		while(n>0){
			sum++;
			n/=2;
			}
		int [] arr = new int[sum];
		
		System.out.print("Това е остатъкът: ");
		int index=0;
		while(n1>0){
			int rest=n1%2;
			arr[index]=rest;
			
			System.out.print(rest+ " ");
			n1/=2;
			index++;
			
		}
		System.out.println();
		
		
		int index2=0; 
		int indexSub=1;
		while(index2<=arr.length/2){
		int temp=arr[index2];
		arr[index2]=arr[arr.length -indexSub];
		arr[arr.length-indexSub]=temp;
		
		index2++;
		indexSub++;
		}
		
		System.out.print("Числото в двоична бройна система: ");
		for(int index1=0; index1<arr.length;index1++){
			System.out.print(arr[index1] + " ");
		}
		
	

	}

}
