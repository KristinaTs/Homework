import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;

import java.util.List;

public class CountLetters {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	System.out.println("Input string:");
	String text=scan.nextLine();
	int lengthOfText=text.length();
	text = text.toString().trim().toLowerCase().replaceAll("[^a-z]","");

		String[] letters = text.split("");
		Map<String, Integer> lettersCount = new HashMap<String, Integer>();
		for (String letter : letters) {
			if (!(lettersCount.containsKey(letter))) {
				lettersCount.put(letter, 1);
			}
			else {
				lettersCount.put(letter, lettersCount.get(letter)+1);
			}
		}
		

		
		List<String> letterList = new ArrayList<String>();
		letterList.addAll(lettersCount.keySet());
		Collections.sort(letterList, (letter1, letter2) -> lettersCount.get(letter2) - lettersCount.get(letter1));
		
		for (String letter : letterList) {
			System.out.print( letter+ " : " + 
					lettersCount.get(letter)+ " ");
			double numberOfTimes=((double)lettersCount.get(letter)/(double)lengthOfText)*100;
			for(int i=0;i<numberOfTimes-1;i++){
				System.out.print("#");
			}
			System.out.println();
		}
	scan.close();
}
}
