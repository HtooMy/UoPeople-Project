/*
 * Reports for the time record
 * 
 * Array Size 1000
 * InsertionSort time in millisecond is 3
 * Array sorting time in millisecond is 1
 * 
 * Array Size 10000
 * InsertionSort time in millisecond is 62
 * Array sorting time in millisecond is 7
 * 
 * Array Size 100000
 * InsertionSort time in millisecond is 3809
 * Array sorting time in millisecond is 61
 * 
 */
public class Assignment1 {
	public static void main(String[] args) {
		BenchMarkingSortingAlgorithms test = new BenchMarkingSortingAlgorithms();
		test.sortingTimeRecord();

	}
}
