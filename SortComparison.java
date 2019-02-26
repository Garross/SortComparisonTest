
// -------------------------------------------------------------------------
import java.util.*;

/**
 * This class contains static methods that implementing sorting of an array of
 * numbers using different sort algorithms.
 *
 * @author Garry Tiscovschi
 * @version HT 2019
 */

class SortComparison {

	public static void main(String[] args) {
		
		SortComparisonTest.testInsertionSort();
		SortComparisonTest.testQuickSort();
		SortComparisonTest.testSelectionSort();
		SortComparisonTest.testMergeSortIterative();
		SortComparisonTest.testMergeSortRecursice();

//		double[] a = {6,5,7,800, -1000, 5,1,1,10,102};
//
//		System.out.println("Before Sort");
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
//		System.out.println("After Sort");
//		a = selectionSort(a);
//		for (int i = 0; i < a.length; i++) {
//			System.out.println(a[i]);
//		}
	}

	/**
	 * Sorts an array of doubles using InsertionSort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order.
	 *
	 */
		public static double[] insertionSort(double a[]) {
		
		if(a == null) return null;
		for (int j = 1; j < a.length; j++) {
			double key = a[j];
			int i = j - 1;
			while (i != -1 && a[i] > a[i + 1]) {
				double temp = a[i + 1];
				a[i + 1] = a[i];
				a[i] = temp;
				i--;

			}
		}

		return a;

	}// end insertionsort

	/**
	 * Sorts an array of doubles using Quick Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
		//Always make sure that the end parameter sent in is 1 less than the arr length to avoid
		//out of bound exceptions
		public static double[] quickSort(double a[], int begin, int end) {
		
		if (begin < end) {
			int partitionIndex = partition(a, begin, end);

			quickSort(a, begin, partitionIndex - 1);
			quickSort(a, partitionIndex + 1, end);
		}
		return a;
	}// end quicksort

		public static int partition(double a[], int begin, int end) {
		double pivot = a[end];
		int i = (begin - 1);

		for (int j = begin; j < end; j++) {
			if (a[j] <= pivot) {
				i++;
				
				
				
				double swapTemp = a[i];

				a[i] = a[j];
				a[j] = swapTemp;
			}
		}

		double swapTemp = a[i + 1];
		a[i + 1] = a[end];
		a[end] = swapTemp;

		return i + 1;
	}
	/**
	 * Sorts an array of doubles using Merge Sort. This method is static, thus
	 * it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	/**
	 * Sorts an array of doubles using iterative implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	
	public static double[] mergeSortIterative(double a[]) 
	{
		if(a == null)
		{
			return null;
		}
		

		for(int length=1; length <= a.length; length=length+length)
		{
			for(int left = 0; left < a.length - length; left += 2*length)
			{
				int median = length + left - 1;
				int right = Math.min(length*2 + left -1, a.length-1);
				mergeIterative(a, left, median, right);
			}
		}
		return a;
	}// end mergesortIterative
		
	

	static void mergeIterative(double[] a, int left, int median, int right) {
		int s1 = median - left + 1;
		int s2 = right - median;

		double[] a1 = new double[s1];
		double[] a2 = new double[s2];
		
		for (int count1 = 0; count1 < s1; count1++) {
			a1[count1] = a[left + count1];
		}
		for (int count2 = 0; count2 < s2; count2++) {
			a2[count2] = a[median + count2 + 1];
		}

		int i = 0;
		int i2 = 0;
		int k = left;
		
		while (i < s1 && i2 < s2) {
			if (a1[i] <= a2[i2]) {
				a[k] = a1[i];
				i++;
			} else {
				a[k] = a2[i2];
				i2++;
			}
			k++;
		}

		while (i < s1) {
			a[k] = a1[i];
			i++;
			k++;
		}
		while (i2 < s2) {
			a[k] = a2[i2];
			i2++;
			k++;
		}
	}

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	
	public static double[] mergeSortRecursive(double a[]) {
		if(a == null) return null;
		if (a.length <=1) return a;

		double x = a.length / 2;
		int mid = (int) Math.floor(x);

		double[] arr1 = new double[mid];
		double[] arr2 = new double[a.length - mid];

		System.arraycopy(a, 0, arr1, 0, mid);
		System.arraycopy(a, mid, arr2, 0, a.length - mid);

		arr1 = mergeSortRecursive(arr1);
		arr2 = mergeSortRecursive(arr2);

		return merge(arr1, arr2);

		// todo: implement the sort

	}// end mergeSortRecursive

	public static double[] merge(double[] arr1, double[] arr2) {
		int i = 0;
		int j = 0;
		int count = 0;

		double[] arr3 = new double[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length && count < arr3.length) {

			if (arr1[i] <= arr2[j]) {
				arr3[count] = arr1[i];
				i++;
			} else {
				arr3[count] = arr2[j];
				j++;
			}
			count++;
		}

		while (i < arr1.length) {
			arr3[count] = arr1[i];
			i++;
			count++;
		}
		while (j < arr2.length) {
			arr3[count] = arr2[j];
			j++;
			count++;
		}
		return arr3;
	}

	/**
	 * Sorts an array of doubles using Selection Sort. This method is static,
	 * thus it can be called as SortComparison.sort(a)
	 * 
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return array sorted in ascending order
	 *
	 */
	public static double[] selectionSort(double a[]) {
		
		if(a == null) return null;

		for (int i = 0; i < a.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < a.length; j++)
				if (a[j] < a[index])
					index = j;

			double smallerNumber = a[index];
			a[index] = a[i];
			a[i] = smallerNumber;
		}
		return a;
	}// end selectionsort

}// end class
