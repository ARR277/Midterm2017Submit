package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */
		LinkedQueue<Integer> qList = new LinkedQueue<>();
		Random rand = new Random();
		int max = rand.nextInt(4)+10;
		for(int i=0, number; i<max; i++) {
			number = rand.nextInt(100)+1;
			System.out.println("push("+number+")");
			qList.push(number);
		}

		qList.print();
		System.out.println("isEmpty() the value: "+qList.isEmpty());
		qList.print();
		System.out.println("pop() the value: "+qList.pop());
		System.out.println("pop() the value: "+qList.pop());
		System.out.println("pop() the value: "+qList.pop());
		qList.print();
		System.out.println("first() the value: "+qList.first());
		System.out.println("size() the value: "+qList.size());
	}

	private static class LinkedQueue<AnyType> implements Queue<AnyType>{

		private LinkedList<AnyType> data = new LinkedList<>();

		public LinkedQueue(){
			data=new LinkedList<>();
		}

		public int size(){
			return data.size();
		}

		public boolean isEmpty(){
			return data.isEmpty();
		}

		public void push(AnyType newValue){
			data.add(newValue);
		}

		public AnyType first(){
			return data.get(0);
		}

		public AnyType pop(){
			return data.remove(0);
		}

		public void print() {
			Iterator<AnyType> itr = data.iterator();
			while(itr.hasNext()) {
				System.out.print(itr.next());
				if(itr.hasNext())System.out.print(" ");
				else System.out.println();
			}
		}

	}

	private interface Queue<AnyType> {

		//returns the number of data values in the queue.
		int size();

		//returns a boolean indicating whether the queue is empty.
		boolean isEmpty();

		//insert a data value to the  back of the queue.
		void push(AnyType newValue);

		//returns the data value at the front of the queue without removing it.
		AnyType first();

		//remove 1 data value from the front of the queue.
		AnyType pop();

	}

}
