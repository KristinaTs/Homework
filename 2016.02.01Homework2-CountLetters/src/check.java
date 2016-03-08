
import java.util.List;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class check {
	public static void main(String[] args) throws MalformedURLException, IOException {
//		Scanner sc = new Scanner(new URL("http://textfiles.com/games/arcade_c.hea").
//				openStream());
//		StringBuilder b = new StringBuilder("");
//		while (sc.hasNextLine()) {
//			b.append(sc.nextLine());
//			b.append("\n");
//		}
//		sc.close();
		
		String text="the robot is a robot";
		 text = text.toString().trim().toLowerCase().replaceAll("[^a-z]", "").replaceAll("( )+ ", " ");
//		System.out.println(text);
		String[] words = text.split("");
		Map<String, Integer> wordsCount = new HashMap<String, Integer>();
		for (String word : words) {
			if (!(wordsCount.containsKey(word))) {
				wordsCount.put(word, 1);
			}
			else {
				wordsCount.put(word, wordsCount.get(word)+1);
			}
		}
		
//		for (String word : wordsCount.keySet()) {
//			System.out.println("\"" + word + "\"" + " se sreshta ei tolkoz pyti " + 
//								wordsCount.get(word));
//		}
		
		List<String> wordsList = new ArrayList<String>();
		wordsList.addAll(wordsCount.keySet());
		Collections.sort(wordsList, (word1, word2) -> wordsCount.get(word1) - wordsCount.get(word2));
		
		for (String word : wordsList) {
			System.out.println("\"" + word + "\"" + " se sreshta ei tolkoz pyti " + 
					wordsCount.get(word));
		}
		
//		Map<Integer, List<String>> freq = new TreeMap<Integer, List<String>>();
//		
//		for (String word : wordsCount.keySet()) {
//			Integer wordCount = wordsCount.get(word);
//			
//			if (!(freq.containsKey(wordCount))) {
//				List<String> wordsForThisCount = new LinkedList<String>();
//				freq.put(wordCount, wordsForThisCount);
//			}
//			
//			List<String> wordsForThisCount = freq.get(wordCount);
//			wordsForThisCount.add(word);
//		}
//		
//		for (Integer wordCount : freq.keySet()) {
//			System.out.print(wordCount + " : ");
//			freq.get(wordCount).forEach(word -> System.out.print(word + ", "));
//			System.out.println();
//		}
//		
	}
}
