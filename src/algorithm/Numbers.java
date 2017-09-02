package algorithm;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import databases.ConnectDB;

/*
 *Created by PIIT_NYA on 04/22/2017.
 */
public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting.Example in below.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 */
	final static int capacity = 100;
	public static void main(String[] args) throws Exception {

		int [] numSelection = new int[capacity];
		int [] numInsertion = new int[capacity];
		int [] numBubble = new int[capacity];
		int [] numMerge = new int[capacity];
		int [] numQuick = new int[capacity];
		int [] numHeap = new int[capacity];
		int [] numBucket = new int[capacity];
		int [] numShell = new int[capacity];

		Random rand = new Random();
		for(int i=0; i<capacity; i++){
			numSelection[i] = rand.nextInt(1000);
			numInsertion[i] = rand.nextInt(1000);
			numBubble[i] = rand.nextInt(1000);
			numMerge[i] = rand.nextInt(1000);
			numQuick[i] = rand.nextInt(1000);
			numHeap[i] = rand.nextInt(1000);
			numBucket[i] = rand.nextInt(1000);
			numShell[i] = rand.nextInt(1000);
		}

		ConnectDB connectDB = new ConnectDB();
		Sort algo = new Sort();
		//Selection Sort
		System.out.println("Selection Sort-->");
		algo.selectionSort(numSelection);
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ numSelection.length
				+ " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectDB.InsertDataFromArryToMySql(numSelection, "selection_sort", "SortingNumbers");
        List<String> numbers = connectDB.readDataBase("selection_sort", "SortingNumbers");
        for(String st:numbers){
        	System.out.println(st);
        }
		int n = capacity;
		randomize (numSelection, n);

		//Insertion Sort
		System.out.println("\nInsertion Sort-->");
		algo.insertionSort(numInsertion);
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numInsertion.length
				+ " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");

		//Continue for rest of the Sorting Algorithm....

		//Bubble Sort
		System.out.println("\nBubble Sort-->");
		algo.bubbleSort(numBubble);
		long bubbleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numBubble.length
				+ " numbers in Bubble Sort take: " + bubbleSortExecutionTime + " milli sec");

		//Merge Sort
		System.out.println("\nMerge Sort-->");
		algo.mergeSort(numMerge);
		long mergeSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numMerge.length
				+ " numbers in Merge Sort take: " + mergeSortExecutionTime + " milli sec");

		//Quick Sort
		System.out.println("\nQuick Sort-->");
		algo.quickSort(numQuick, 0, numQuick.length-1);
		long quickSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numQuick.length
				+ " numbers in Quick Sort take: " + quickSortExecutionTime + " milli sec");

		//Heap Sort
		System.out.println("\nHeap Sort-->");
		algo.heapSort(numHeap);
		long heapSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numHeap.length
				+ " numbers in Heap Sort take: " + heapSortExecutionTime + " milli sec");

		//Bucket Sort
		System.out.println("\nBucket Sort-->");
		algo.bucketSort(numBucket, 20);
		long bucketSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numBucket.length
				+ " numbers in Bucket Sort take: " + bucketSortExecutionTime + " milli sec");

		//Shell Sort
		System.out.println("\nShell Sort-->");
		algo.shellSort(numShell);
		long shellSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + numShell.length
				+ " numbers in Shell Sort take: " + shellSortExecutionTime + " milli sec");
	}

	private static void randomize( int arr[], int n)
	{
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
