import java.util.Scanner;

public class task9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете големината на масива:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		
		int index=0; 
		int indexSub=1;
		while(index<=arr.length/2){
			int temp=arr[index];
			arr[index]=arr[arr.length -indexSub];
			arr[arr.length-indexSub]=temp;
			
			index++;
			indexSub++;
			}
		
		for(int index1=arr.length-1; index1>=0;index1--){
			System.out.print(arr[index1] + " ");
		}
		

	}

}
