import java.util.Scanner;

public class task10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int [] arr = new int [7];
		
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<7;index++){
			arr[index]=scan.nextInt();
		}
		
		int sum=0;
		
		for(int index=0; index<arr.length; index++){
			sum=sum+arr[index];
		}
		 double middle=(double)sum/7;
		 double min=middle;
		 int middleElement=0;
		 for(int ind=0; ind<arr.length; ind++){
			 double sub=middle-arr[ind];
			 
			 if(sub>0 && sub<=min){
				 min=sub;
				 middleElement=arr[ind];
				 }
			 if(sub<0 && sub*(-1)<=min){
				 min=sub*(-1);
				 middleElement=arr[ind];
				 }
			 if(sub==0){
				 min=0;
				 middleElement=arr[ind];
			 }
		 }
		 System.out.println("Средната стойност е: " + middle);
		 System.out.println(middleElement);

	}

}
