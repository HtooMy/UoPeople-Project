import java.util.Arrays;

/**
 * BenchMarkingSortingAlgorithms provides the runtime record comparison of the
 * two sorting methods:
 * Built-in sorting method (Arrays.sort()) and Intertion Sorting method
 * This program is created as the following:
 * Firstly,two arrays of type int[] are created. Both arrays are the same size
 * filled with the random number.
 * And then the first array is sorted using Insertion Sort and the second, built
 * in sorting method
 * Finally sortingTimeRecord method is created to record the runtime of both
 * sorting methods
 */

public class BenchMarkingSortingAlgorithms {
	int arraySize = 100000; // The maximum array size for both array
	int[] firstArray = new int[arraySize]; // First array
	int[] secondArray = new int[arraySize]; // Second array

	// Constructor for assigning values in the arrays
	public BenchMarkingSortingAlgorithms() {
		for (int i = 0; i < arraySize; i++) {
			// Assigning random numbers in two arrays
			firstArray[i] = (int) (Integer.MAX_VALUE * Math.random());
			secondArray[i] = firstArray[i];
		}
	}

	/*
	 * After this method is called, the runtime record for the two sorting methods
	 * will be outputed
	 */
	public void sortingTimeRecord() {
		// General method for getting the runtime of a code
		long startTimeFirstArray = System.currentTimeMillis();
		insertionSort(firstArray);
		long runTimeFirstArray = System.currentTimeMillis() - startTimeFirstArray;

		long startTimeSecondArray = System.currentTimeMillis();
		Arrays.sort(secondArray);
		long runTimeSecondArray = System.currentTimeMillis() - startTimeSecondArray;

		System.out.println("InsertionSort time in millisecond is " + runTimeFirstArray);
		System.out.println("Array sorting time in millisecond is " + runTimeSecondArray);
	}

	static void insertionSort(int[] A) {
		// Sort the array A into increasing order.
		int itemsSorted; // Number of items that have been sorted so far.
		for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
			// Assume that items A[0], A[1], ... A[itemsSorted-1]
			// have already been sorted. Insert A[itemsSorted]
			// into the sorted part of the list.
			int temp = A[itemsSorted]; // The item to be inserted.
			int loc = itemsSorted - 1; // Start at end of list.
			while (loc >= 0 && A[loc] > temp) {
				A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
				loc = loc - 1; // Go on to next location.
			}
			A[loc + 1] = temp; // Put temp in last vacated space.
		}
	}

}
