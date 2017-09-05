package datastructure;

import databases.ConnectDB;

import java.io.*;
import java.util.*;

public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */
		ConnectDB connectDB = new ConnectDB();
		String textFile = System.getProperty("user.dir") + "/src/data/self-driving-car";
		Stack<String> stack = new Stack<>();
		LinkedList<String> linkedList = new LinkedList<>();
//		String line;

		File filePath = new File(textFile);
		try {
			String in = "";
//			FileReader fr = new FileReader(filePath);
//			BufferedReader br = new BufferedReader(fr);
			Scanner sc = new Scanner(filePath);
			while (sc.hasNext()){
				in = sc.next();
				stack.push(in);
				linkedList.add(in);
			}

//			while((line = br.readLine())!=null) {
//				stack.push(line);
//				linkedList.add(line);
//			}
			sc.close();
//			br.close();

		}catch(IOException ioe) {
			ioe.printStackTrace();
			System.out.println(ioe.getMessage());
		}
		String dequeue;
		System.out.println("LinkedList size = "+linkedList.size()+" | Stack size = "+stack.size()+"\n");
		System.out.println("LinkedList: ");
		while( (dequeue = linkedList.pollFirst())!=null ){
			System.out.println(dequeue);
		}
		System.out.println("\nStack: ");
		while( stack.size()!=0 ){
			System.out.println(stack.pop());
		}
		System.out.println("\nLinkedList size = "+linkedList.size()+" | Stack size = "+stack.size());

	}

}
