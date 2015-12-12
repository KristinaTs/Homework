import java.util.Scanner;

public class task5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		String str1=scan.next();
		String str2=scan.next();
		
		int position=0;
		
		
		for(int index=0;index<str2.length();index++){
		position = str1.indexOf(str2.charAt(index));
		if(position>0){
			break;
		}
		}
		if(position<0){
			System.out.println("Няма еднакви букви!");
		}else{
		int position2=str2.indexOf(str1.charAt(position));
		for(int index=0; index<str1.length();index++){
		
			if(index==position){
				System.out.println(str2);
				continue;
			}
			for(int i=1;i<=position2;i++){
				System.out.print(" ");
			}
			System.out.println(str1.charAt(index));
			
		}
		}
	}

}
