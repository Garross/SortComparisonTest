
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

		double[] a = { 3, 2, 5, 1, 4, 12, 30, 15, 20, 1, 1, 1, 500.2, -1000 };

		System.out.println("Before Sort");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("After Sort");
		a = selectionSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
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
	static double[] insertionSort(double a[]) {

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
	static double[] quickSort(double a[], int begin, int end) {

		if (begin < end) {
			int partitionIndex = partition(a, begin, end);

			quickSort(a, begin, partitionIndex - 1);
			quickSort(a, partitionIndex + 1, end);
		}
		return a;
	}// end quicksort

	private static int partition(double a[], int begin, int end) {
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

	static double[] mergeSortIterative(double a[]) {

		// todo: implement the sort
		return a;
	}// end mergesortIterative

	/**
	 * Sorts an array of doubles using recursive implementation of Merge Sort.
	 * This method is static, thus it can be called as SortComparison.sort(a)
	 *
	 * @param a:
	 *            An unsorted array of doubles.
	 * @return after the method returns, the array must be in ascending sorted
	 *         order.
	 */
	static double[] mergeSortRecursive(double a[]) {

		if (a.length == 1)
			return a;

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
	static double[] selectionSort(double a[]) {

		 for (int i = 0; i < a.length - 1; i++)
	        {
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
