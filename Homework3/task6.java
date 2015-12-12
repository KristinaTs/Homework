import java.util.Scanner;

public class task6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете големината на масива:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		System.out.println("Въведете големината на масива:");
		int size1=scan.nextInt();
		int [] arr1 = new int [size1];
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size1;index++){
			arr1[index]=scan.nextInt();
		}
		
		
	
		
		boolean isEquel=false;
		if(size!=size1){
			System.out.println("Масивите не са с еднакъв размер");
		}else{
			for(int ind=0; ind<size;ind++){
				if(arr[ind]==arr1[ind]){
					isEquel=true;
				}
			}
			if(isEquel==true){
				System.out.println("Масиви са с еднакъв размер и са еднакви!");
			}else{
				System.out.println("Масиви са с еднакъв размер,но са различни!");
			}
		}
	}

}
