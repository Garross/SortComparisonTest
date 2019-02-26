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
 *  Test class for SortComparison.java
 *
 *  @author
 *  @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest
{
	//~ Constructor ........................................................
	@Test
	public void testConstructor()
	{
		new SortComparison();
	}

	//~ Public Methods ........................................................

	// ----------------------------------------------------------
	/**
	 * Check that the methods work for empty arrays
	 */
	
	
	@Test
	public void testEmpty()
	{
		double[] arr1 = new double[]{};
		double[] arr2 = new double[]{};
		
		assertEquals("Checking empty array - selectionSort",
				Arrays.toString(arr1), Arrays.toString(SortComparison.selectionSort(arr2)));
		
		arr2 = new double[]{};
		assertEquals("Checking empty array - mergeSortIterative",
				Arrays.toString(arr1), Arrays.toString(SortComparison.mergeSortIterative(arr2)));
		
		arr2 = new double[]{};
		assertEquals("Checking empty array tree - mergeSortRecursive",
				Arrays.toString(arr1), Arrays.toString(SortComparison.mergeSortRecursive(arr2)));
		
		arr2 = new double[]{};
		assertEquals("Checking empty array tree - quickSort",
				Arrays.toString(arr1), Arrays.toString(SortComparison.quickSort(arr2, 0 , arr2.length)));
		
		arr2 = new double[]{};
		assertEquals("Checking empty array tree - insertionSort",
				Arrays.toString(arr1), Arrays.toString(SortComparison.insertionSort(arr2)));		
	}
	
	@Test
	public void testSort() 
	{
		double[] a = new double[]{6,1,6.7,89,2,1};
		double[] s = new double[]{1,1,2,6,6.7,89};
		
		assertEquals("Checking normal array - insertionSort",
				Arrays.toString(s), Arrays.toString(SortComparison.insertionSort(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking normal array - selectionSort",
				Arrays.toString(s), Arrays.toString(SortComparison.selectionSort(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking normal array - mergeSortIterative",
				Arrays.toString(s), Arrays.toString(SortComparison.mergeSortIterative(a)));
		
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking normal array - mergeSortRecursive",
				Arrays.toString(s), Arrays.toString(SortComparison.mergeSortRecursive(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking normal array - quickSort",
				Arrays.toString(s), Arrays.toString(SortComparison.quickSort(a,0, a.length)));
		
		
	}
	
	@Test
	public void testNull()
	{
		assertEquals("Checking null array - insertionSort",
				null, SortComparison.insertionSort(null));
		
		assertEquals("Checking null array - selection",
				null, SortComparison.selectionSort(null));
		
		assertEquals("Checking null array - quickSort",
				null, SortComparison.quickSort(null , 0 , 0));
		
		assertEquals("Checking null array - mergeSort",
				null, SortComparison.mergeSortIterative(null));
		
		assertEquals("Checking null array - mergeSort",
				null, SortComparison.mergeSortRecursive(null));
	}
	
	@Test
	public void testSorted() {
		
		double[] a = new double[]{1,1,2,6,6.7,89};
		double[] s = new double[]{1,1,2,6,6.7,89};
		
		assertEquals("Checking sorted array - insertionSort",
				Arrays.toString(s), Arrays.toString(SortComparison.insertionSort(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking sorted array - selectionSort",
				Arrays.toString(s), Arrays.toString(SortComparison.selectionSort(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking sorted array - mergeSortIterative",
				Arrays.toString(s), Arrays.toString(SortComparison.mergeSortIterative(a)));
		
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking sorted array - mergeSortRecursive",
				Arrays.toString(s), Arrays.toString(SortComparison.mergeSortRecursive(a)));
		
		a = new double[]{6,1,6.7,89,2,1};
		assertEquals("Checking sorted array - quickSort",
				Arrays.toString(s), Arrays.toString(SortComparison.quickSort(a, 0 , a.length)));
	}
	

	/**
	 *  Main Method.
	 *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
	 *
	 */
	
	
	/**
	 * Performance Testing(time in MS)
	 * 
	 * 					|Insert			|Quick			|Selection 		|merge recursive|Merge Iterative|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 10			| 4 | 4 | 4		| 0 | 1 | 1		| 0 | 0 | 0		| 0 | 0 | 0		| 0 | 0	| 0		|
	 * Average			| 4				| 0.667			| 0				| 0				| 0				|
	 * -----------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 100			| 4 | 3 | 3		| 1 | 0	| 0		| 1 | 0 | 0		| 0 | 0 | 0		| 1 | 1 | 0		|
	 * Average			| 3.333			| 0.333			| 0.333			| 0 			| 0.667			|
	 * -----------------|---------------|---------------|---------------|---------------|---------------| 
	 * n = 1000			| 11| 11 | 11	| 1 | 1 | 2		| 2	| 3	| 3		| 1 | 1	| 1		| 0 | 1	| 2		|
	 * Average			| 11			| 1.333			| 2.667			| 1				| 1				|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 1000	dup		| 8 | 5 | 5		| 1 | 1 | 1		| 5 | 6 | 6		| 1 | 0 | 0		| 1 | 1 | 1		|
	 * Average			| 6				| 1				| 5.667			| 0.333			| 1 			|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 1000	near ord| 9 | 9 | 9		| 1 | 2	| 2		| 0 | 1 | 1		| 0	| 1 | 1		| 0 | 0	| 0		|
	 * Average			| 9				| 1.667			| 0.667			| 0.667			| 0				|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 1000	reverse	| 9 | 9 | 10	| 3 | 3 | 5		| 1	| 1	| 1		| 1	| 1	| 1		| 1 | 1 | 1		|
	 * Average			| 9.333			| 3.667			| 1				| 1 			| 1 			|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * n = 1000	sorted	| 8 | 7 | 8		| 1 | 1 | 2		| 1 | 1 | 2		| 1 | 0	| 0		| 0 | 0 | 1		|
	 * Average			| 7.667			| 1.333			| 1.333			| 0.333			| 0.333			|
	 *------------------|---------------|---------------|---------------|---------------|---------------|
	 * 
	 */
	
	
//	public static void main(String[] args)
//	{
//		SortComparisonTest.testInsertionSort();
//		SortComparisonTest.testQuickSort();
//		SortComparisonTest.testSelectionSort();
//		SortComparisonTest.testMergeSortIterative();
//		SortComparisonTest.testMergeSortRecursice();
//	}
			
	public static void testInsertionSort()
	{
		//test insertion sort
		System.out.println("INSERTION SORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.insertionSort(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finishTime - startTime) + " ms");
	}
	
	public static void testSelectionSort()
	{
		System.out.println("SELECTION SORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.selectionSort(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finishTime - startTime) + " ms");
	}
	
	public static void testMergeSortIterative()
	{
		System.out.println("MERGESORT ITERATIVE-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortIterative(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finishTime - startTime) + " ms");
	}
	
	public static void testMergeSortRecursice()
	{
		System.out.println("MERGESORT RECURSIVE-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(10, ""));
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(100, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, ""));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Duplicates"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "NearlyOrdered"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Reverse"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.mergeSortRecursive(readFile(1000, "Sorted"));
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finishTime - startTime) + " ms");
	}
	
	//Remember Quick Sort always needs the array length -1 as a a parameter to avoid going out of bounds
	public static void testQuickSort()
	{
		System.out.println("QUICKSORT-------------------------------------------");
		long startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(10, ""),0, readFile(10, "").length-1 );
		long finishTime = System.currentTimeMillis();
		System.out.println("n=10 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(100, ""),0, readFile(100, "").length-1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=100 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "") ,0, readFile(1000, "").length -1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000 takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Duplicates") ,0, readFile(1000, "Duplicates").length -1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Duplicates takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "NearlyOrdered"),0, readFile(1000, "NearlyOrdered").length -1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, NearlyOrdered takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Reverse"),0, readFile(1000, "Reverse").length -1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Reverse takes: " + (finishTime - startTime) + " ms");
		
		startTime = System.currentTimeMillis();
		SortComparison.quickSort(readFile(1000, "Sorted"),0, readFile(1000, "Sorted").length -1 );
		finishTime = System.currentTimeMillis();
		System.out.println("n=1000, Sorted takes: " + (finishTime - startTime) + " ms");
	}
	
	
	public static double[] readFile(int num, String type) {
		
		double[] a = new double[num];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("numbers"+type+num+".txt"));
			
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

