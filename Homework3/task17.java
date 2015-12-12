import java.util.Scanner;

public class task17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Въведете големината на масива:");
		int size = scan.nextInt();
		int [] arr = new int[size];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		boolean isZigi=true;
		
		for(int index1=1; index1<arr.length-1;index1=index1+2)
		{
			
				if(arr[index1-1]>arr[index1]){
				isZigi=false;
			}
				if(arr[index1]<arr[index1+1]){
					isZigi=false;
				}
			
		}
		
		if(isZigi==true){
			System.out.println("Редицата е зигзагообразна нагоре ");
		}
		else{
			System.out.println("Редицата не е зигзагообразна нагоре  ");
		}

	}

}
