package datastructure;

import java.util.*;

public class UseMap {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */
		Map<String, List<String>> wordList = new HashMap<String, List<String>>();
		List<String> one = new LinkedList<String>();
		List<String> two = new LinkedList<String>();
		List<String> three = new LinkedList<String>();
		String wordOne, wordTwo, wordThree;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any 15 words: ");
		while(sc.hasNext()){
			wordOne = sc.next();
			wordTwo = sc.next();
			wordThree = sc.next();
			count++;
			one.add(wordOne);
			two.add(wordTwo);
			three.add(wordThree);
			if(count==5)break;
		}
		sc.close();
		wordList.put(" Set 1 ", one);
		wordList.put(" Set 2 ", two);
		wordList.put(" Set 3 ", three);

		for(Map.Entry<String, List<String>> print : wordList.entrySet()){
			System.out.println(print.getKey()+"  "+print.getValue());
		}
		System.out.println(wordList.get(" Set 2 "));
	}

}
