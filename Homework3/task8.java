import java.util.Scanner;

public class task8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете големината на масива:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		//for(int index1=0; index1<arr.length;index1++){
			//System.out.print(arr[index1] + " ");
		//}
		System.out.println();
		
		int sum=1;
		int max=1;
		int maxElement=0;
		
		
		for(int i =0; i<size-2;i++){
			
			if(arr[i]==arr[i+1]){
				sum++;
				if(sum>max){
					max=sum;
					maxElement=arr[i];
					
				}
			}
			else{
				sum=0;
			}
			}
		
		if(max==1){
			System.out.println("Няма най-дълга редица");
		}else{
		
		for(int j=0;j<=max;j++){
			System.out.print(maxElement + " ");
		}
		}
		
		
	}

}
