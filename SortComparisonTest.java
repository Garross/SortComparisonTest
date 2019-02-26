import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 * Test class for SortComparison.java
 *
 * @author
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
	
	/**
	 * Performance Testing(time in MS)
	 *  			         |Insert			|Quick			|Selection 		|Merge recursive |Merge Iterative|
	 * n = 10					4					0.333			0				0				0
	 * n = 100					3.66				0.333			0.333			0				0.667	
	 * n = 1000					10.33				1.333			2.667			1				1
	 * n = 1000	duplicate		9					2				5.66			0.333			1
	 * n = 1000	near order		9					1.33			0.667			0.667			0
	 * n = 1000	reverse			9					3.66			1				1				1
	 * n = 1000	sorted			8					1.33			1.33			0.333			0.33
	 * 
	 * 
	 * 
	 * 
	 * **/
//	
//			a. Which of the sorting algorithms does the order of input have an impact on? Why?
			
//			 Quick sort , because its partition algorithm has to make the maximum number of swaps since when the 
//			 when the array is reverse sorted the maximum amount of numbers are greater than the partition value are
// 			 below the partition in the list.
	
//			b. Which algorithm has the biggest difference between the best and worst performance, based
//			on the type of input, for the input of size 1000? Why?
	    	 
//			 Quick sort, with an experimental difference of 2.33 ,for the same reasons as listed above.
			 
	
//			c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
//			based on the input size? Please consider only input files with random order for this answer.

//			 Best: Merge sort recursive. Worst : Insertion Sort.
	
//			d. Did you observe any difference between iterative and recursive implementations of merge
//			sort?
	
//			 Recursive seemed more efficient as it it featured almost uniform scaling.
	
//			e. Which algorithm is the fastest for each of the 7 input files? 
//			 Recursive Merge Sort , was faster in all experiments bar one , which may be up to experimental error 
//			,due to how close the results were.
	
	// ~ Constructor ........................................................
	@Test
	public void testConstructor() {
		new SortComparison();
	}

	// ~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */

	@Test
	public void testEmpty() {
		double[] arr1 = {};
		double[] arr2 = {};

		assertEquals("Checking empty array : selectionSort", Arrays.toString(arr1),
				Arrays.toString(SortComparison.selectionSort(arr2)));

		arr2 = new double[] {};
		assertEquals("Checking empty array : mergeSortIterative", Arrays.toString(arr1),
				Arrays.toString(SortComparison.mergeSortIterative(arr2)));

		arr2 = new double[] {};
		assertEquals("Checking empty array tree : mergeSortRecursive", Arrays.toString(arr1),
				Arrays.toString(SortComparison.mergeSortRecursive(arr2)));

		arr2 = new double[] {};
		assertEquals("Checking empty array tree : quickSort", Arrays.toString(arr1),
				Arrays.toString(SortComparison.quickSort(arr2, 0, arr2.length)));

		arr2 = new double[] {};
		assertEquals("Checking empty array tree : insertionSort", Arrays.toString(arr1),
				Arrays.toString(SortComparison.insertionSort(arr2)));
	}

	@Test
	public void testSort() {
		double[] arr1 = { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		double[] arr2 = { -1000, 1, 1, 5, 5, 6, 7, 10, 102, 800 };

		assertEquals("Checking normal array : insertionSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.insertionSort(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking normal array : selectionSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.selectionSort(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking normal array : mergeSortIterative", Arrays.toString(arr2),
				Arrays.toString(SortComparison.mergeSortIterative(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking normal array : mergeSortRecursive", Arrays.toString(arr2),
				Arrays.toString(SortComparison.mergeSortRecursive(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking normal array : quickSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.quickSort(arr1, 0, arr1.length - 1)));

	}

	@Test
	public void testNull() {
		assertEquals("Checking null array : insertionSort", null, SortComparison.insertionSort(null));

		assertEquals("Checking null array : selection", null, SortComparison.selectionSort(null));

		assertEquals("Checking null array : quickSort", null, SortComparison.quickSort(null, 0, 0));

		assertEquals("Checking null array : mergeSort", null, SortComparison.mergeSortIterative(null));

		assertEquals("Checking null array : mergeSort", null, SortComparison.mergeSortRecursive(null));
	}

	@Test
	public void testSorted() {

		double[] arr1 = { -1000, 1, 1, 5, 5, 6, 7, 10, 102, 800 };
		double[] arr2 = { -1000, 1, 1, 5, 5, 6, 7, 10, 102, 800 };

		assertEquals("Checking sorted array : insertionSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.insertionSort(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking sorted array : selectionSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.selectionSort(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking sorted array : mergeSortIterative", Arrays.toString(arr2),
				Arrays.toString(SortComparison.mergeSortIterative(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking sorted array : mergeSortRecursive", Arrays.toString(arr2),
				Arrays.toString(SortComparison.mergeSortRecursive(arr1)));

		arr1 = new double[] { 6, 5, 7, 800, -1000, 5, 1, 1, 10, 102 };
		assertEquals("Checking sorted array : quickSort", Arrays.toString(arr2),
				Arrays.toString(SortComparison.quickSort(arr1, 0, arr1.length - 1)));
	}






	public static void testInsertionSort() {
		// test insertion sort
		System.out.println("INSERTION SORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(10, ""));
		long finTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(100, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Duplicates"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "NearlyOrdered"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Reverse"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Sorted"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finTime - startTime) + " ms");
	}

	public static void testSelectionSort() {
		System.out.println("SELECTION SORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(10, ""));
		long finTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(100, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Duplicates"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "NearlyOrdered"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Reverse"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Sorted"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finTime - startTime) + " ms");
	}

	public static void testMergeSortIterative() {
		System.out.println("MERGESORT ITERATIVE-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(10, ""));
		long finTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(100, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Duplicates"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "NearlyOrdered"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Reverse"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Sorted"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finTime - startTime) + " ms");
	}

	public static void testMergeSortRecursice() {
		System.out.println("MERGESORT RECURSIVE-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(10, ""));
		long finTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(100, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, ""));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Duplicates"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "NearlyOrdered"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Reverse"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Sorted"));
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finTime - startTime) + " ms");
	}

	// Remember Quick Sort always needs the array length -1 as a a parameter to
	// avoid going out of bounds
	public static void testQuickSort() {
		System.out.println("QUICKSORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(10, ""), 0, readFile(10, "").length - 1);
		long finTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(100, ""), 0, readFile(100, "").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, ""), 0, readFile(1000, "").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Duplicates"), 0, readFile(1000, "Duplicates").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "NearlyOrdered"), 0, readFile(1000, "NearlyOrdered").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Reverse"), 0, readFile(1000, "Reverse").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finTime - startTime) + " ms");

		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Sorted"), 0, readFile(1000, "Sorted").length - 1);
		finTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finTime - startTime) + " ms");
	}

	public static double[] readFile(int number, String type) {

		double[] a = new double[number];

		try {
			BufferedReader br = new BufferedReader(new FileReader("numbers" + type + number + ".txt"));

			String line = br.readLine();

			for (int i = 0; line != null; i++) {

				a[i] = Double.parseDouble(line);

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return a;
	}

}
