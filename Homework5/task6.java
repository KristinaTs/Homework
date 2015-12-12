import java.util.Scanner;

public class task6 {

	public static void main(String[] args) {
Scanner scan = new Scanner (System.in);
		
		String str1=scan.nextLine();
		String [] words1=str1.split(" ");
		String str2=str1.toUpperCase();
		String [] words2=str2.split(" ");
		char[] firstLetter=new char[words2.length];
		for(int index=0; index<words2.length;index++){
			 firstLetter[index]=words2[index].charAt(0);
		}
for(int index=0; index<words1.length;index++)	{
	System.out.print(firstLetter[index]+words1[index].substring(1));
	System.out.print(" ");
}

		

	}

}
