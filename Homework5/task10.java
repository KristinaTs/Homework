import java.util.Scanner;

public class task10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		String str1=scan.next();
		char[] change=str1.toCharArray();
		
				char[] symbol=new char[str1.length()];
		for(int index=0;index<str1.length();index++){
			change[index]=(char)(str1.charAt(index)+5);
		}
		for(int index=0;index<change.length;index++){
			symbol[index]=change[index];
		}
		for(int index=0;index<change.length;index++){
			System.out.print(change[index]);
		}

	}

}
