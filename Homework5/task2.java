import java.util.Scanner;

public class task2 {

	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	String str1= scan.next();
	String str2= scan.next();
	
	 
	if(str1.length()<10 || str1.length()>20 || str2.length()<10||str2.length()>20 ){
		System.out.println("Invalid strings");
	}else{
		if(str1.length()>str2.length()){
			System.out.println(str1.length());
		}else{
			System.out.println(str2.length());
		}
//			for(int i=0;i<=4;i++){
//				System.out.print(str1.charAt(i));
//			}
//			for(int i=5;i<str2.length();i++){
//				System.out.print(str2.charAt(i));
//			}
		
		System.out.print(str1.substring(0,5));
		System.out.println(str2.substring(5));
		}
		
	}
	

	}


