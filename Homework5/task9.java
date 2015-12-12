import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class task9 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Въведете текст:");
		String text=scan.nextLine();
		String str = 'a'+text+'a';
		boolean isPositive=true;
		int sum=0;
		int []arr=new int [str.length()];
		int i=0;
		for (int index=1;index<str.length()-1;index++){
			if(str.charAt(index)>='0' && str.charAt(index)<='9'){
				isPositive=true;
				if(str.charAt(index-1)=='-'){
					isPositive=false;
				}
				int number=str.charAt(index)-'0';
				int num=1;
				int temp=0;
				while(str.charAt(index+num)>='0' && str.charAt(index+num)<='9'){
					temp=str.charAt(index+num)-'0';
					number=number*10+temp;
					
					num++;
					}
				index=index+num;
				if(isPositive==true){
				arr[i]=number;
				}else{
					arr[i]=-number;
				}
				i++;
		
		}
	}
		for(int a=0;a<arr.length;a++){
			sum=sum+arr[a];
			System.out.print(arr[a]+ " ");
			}
		System.out.println(sum);
	}
}
