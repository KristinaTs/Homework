import java.util.Scanner;

public class task4 {

	public static void main(String[] args) {
	Scanner scan = new Scanner (System.in);
	
	String str1=scan.nextLine();
	String[] names = str1.split(",");
	
	int sum1=0;
	
	for(int index=0;index<names[0].length();index++){
		sum1+=(int)names[0].charAt(index);
	}
	int sum2=0;
	for(int index=0;index<names[1].length();index++){
	sum2+=(int)names[1].charAt(index);
	}
	
	if(sum1>sum2){
		System.out.println(names[0]);
	}
	if(sum1<sum2){
		System.out.println(names[1]);
	}
	if(sum1==sum2){
		System.out.println("Стойностите са равни.");
	}
	
	}

}
