import java.util.Scanner;

public class task18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Въведете големината на масивите:");
		int size = scan.nextInt();
		int [] arr = new int [size];
		int[] arr1 = new int [size];
		int [] arr2 = new int [size];

		
		System.out.println("Въведете стойностите в първия масив:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		System.out.println("Въведете стойностите във втория масив:");
		for(int index1=0; index1<size;index1++){
			arr1[index1]=scan.nextInt();
		}
		
		for(int i=0;i<size;i++){
			if(arr[i]>=arr1[i]){
				arr2[i]=arr[i];
			}
			else{
				arr2[i]=arr1[i];
			}
		}
		System.out.print("Първият масив е: ");
		for(int index2=0; index2<arr.length;index2++){
			System.out.print(arr[index2] + " ");
		}
		System.out.println();
		System.out.print("Вторият масив е: ");
		for(int index3=0; index3<arr.length;index3++){
			System.out.print(arr1[index3] + " ");
		}
		
		System.out.println();
		System.out.print("Третият масив е: ");
		for(int index4=0; index4<arr.length;index4++){
			System.out.print(arr2[index4] + " ");
		}
		
		
		

	}

}
