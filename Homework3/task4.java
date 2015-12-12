import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Въведете големината на масива:");
		int size=scan.nextInt();
		int [] arr = new int [size];
		System.out.println("Въведете стойностите в масива:");
		for(int index=0; index<size;index++){
			arr[index]=scan.nextInt();
		}
		
		boolean isMirror = true;	
		if(size%2==0){
			
		int i=0;
		int f=size-1;
	while(i<=size/2){
	if(arr[i]!=arr[f]){
		isMirror=false;
		
	}
	i++;
	f--;
			}
		}else{
		
		int middle = arr[(size/2)];
		
		if (middle>9 && middle<-9){
		int newNum=0;
		 boolean isPalidrome= false; 
			do
			 {
			     int  digit = middle% 10;
			      newNum = newNum * 10 + digit;
			      middle/=10;
			      if(middle==newNum){
			    	  isPalidrome = true;
			      }
			 }while (middle > 0);
			if(isPalidrome==false){
				isMirror=false;
			}
		}else{

		int k=0;
		int t=size-1;
		while(k<size/2){
			if(arr[k]!=arr[t]){
				isMirror=false;
			}else{
				isMirror =true;
			}
			k++;
			t--;
		}
		
			
		}
	}
		
		if(isMirror==true){
			System.out.println("Масивът е огледален");
			
		}
		else{
			System.out.println("Масиват не е огледален");
		}
		
		}
	}


