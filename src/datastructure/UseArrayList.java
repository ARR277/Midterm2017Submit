package datastructure;

import java.util.*;

public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 * 
		 */
		String temp;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		List<String> stringArr = new ArrayList<>();
		System.out.print("Enter any words:\n\t- Must be at least 15 words."
				+"\n\t- Enter \"StopAPP\" to finish the entering."
				+"\n\t- Enter \"OverrideExit\" to terminate the application."
				+"\nStart: ");
		while(sc.hasNext()){
			temp = sc.next();
			if(temp.equalsIgnoreCase("StopAPP")){
				if(count<15){
					System.err.print("You have not entered at least 15 words."
							+"\nTotal Word(s): "+count+"\nContinue: ");
					continue;
				}
				break;
			}
			if(temp.equalsIgnoreCase("overrideExit"))System.exit(0);
		//add Arraylist
			stringArr.add(temp);
			count++;
		}
		sc.close();
		Random rand = new Random();
		System.out.println("\nWhatever you enter is added to the ArrayList.");
		System.out.println("Adding \"superman\" and \"Dark_Knight\" to the list at random index.");
		stringArr.add(rand.nextInt(15), "superman");
		stringArr.add(rand.nextInt(15), "Dark_Knight");
		System.out.println("You have entered "+(stringArr.size()-2)
				+" word elements. Plus two more elements.");
		System.out.print("Word List: [");
	//printing in for loop
		for(String print: stringArr){
			System.out.print(" "+print);
		}

		System.out.println(" ]");
	//get the elements of ArrayList from specific index AND
	//set the element to the ArrayList to the random index 0 to 14
		System.out.println("The first element is \""+stringArr.get(0)
				+"\".\nReplacing any element with \"Happy\" element.");
		stringArr.set(rand.nextInt(15), "Happy");
	//access index of the elements
		System.out.println("The \"Happy\" element is located at index "
				+stringArr.indexOf("Happy"));
		Iterator<String> x = stringArr.iterator();
		System.out.print("New Word List: [");
		//print in while loop with iterator
		while(x.hasNext()){
			System.out.print(" "+x.next());
		}
		System.out.println(" ]");
		System.out.println("Now you have "+stringArr.size()+" word elements.");
		System.out.println("When removing \"Pony\" element from the list, Nothing has changed");
		System.out.println("But when removing \"superman\" element from the list, something has changed");
	//remove specific element in ArrayList
		stringArr.remove("superman");
		System.out.print("Newer Word List: [");
		for(String newPrint: stringArr){
			System.out.print(" "+newPrint);
		}
		System.out.println(" ]");
		System.out.println("Now you have "+stringArr.size()+" word elements. Last element is "+stringArr.get(stringArr.size()-1));

	}
}