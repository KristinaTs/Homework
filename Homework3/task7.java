import java.util.Scanner;

public class task7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете големината на масива:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		int [] arr1 = new int [size];
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		arr1[0]=arr[0];
		for(int ind=1; ind<size-1;ind++){
			arr1[ind]=arr[ind-1]+arr[ind+1];
		}
		arr1[arr1.length-1]=arr[arr.length-2];
		for(int index1=0; index1<arr.length;index1++){
			System.out.print(arr1[index1] + " ");
		}
		

	}

}
