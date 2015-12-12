import java.util.Scanner;

public class task7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		String str1=scan.nextLine();
		str1=str1.trim();
		String [] words=str1.split(" ");
		
		int longestWord=words[0].length();;
		for(int index=0; index<words.length-1;index++){
			if(words[index].length()<words[index+1].length()){
				longestWord=words[index+1].length();
			}
		}
		
		System.out.println(words.length+ " думи, най-дългата е с "+ longestWord+ " символа.");
		

	}

}
