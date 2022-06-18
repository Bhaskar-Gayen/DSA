package array;

/**
 * GFG: Count Inversions 
 * Input: N = 5, arr[] = {2, 4, 1, 3, 5} 
 * Output: 3
 */

public class CountInversions {

	// arr[]: Input Array
	// N : Size of the Array arr[]
	// Function to count inversions in the array.
	static long inversionCount(long arr[], long N) {
		long[] temp = new long[(int) N];

		return mergeSort(arr, temp, 0, (int) N - 1);
	}

	static long mergeSort(long[] arr, long[] temp, int l, int r) {
		long invCount = 0;
		if (l < r) {
			int mid = (l + r) / 2;
			invCount += mergeSort(arr, temp, l, mid);
			invCount += mergeSort(arr, temp, mid + 1, r);
			invCount += mergeAndCount(arr, temp, l, mid + 1, r);
		}
		return invCount;
	}

	static long mergeAndCount(long[] arr, long[] temp, int l, int mid, int r) {

		long invCount = 0;
		int i = l, j = mid, k = l;
		while (i <= mid - 1 && j <= r) {
			if (arr[i] <= arr[j])
				temp[k++] = arr[i++];
			else {
				temp[k++] = arr[j++];
				invCount += (mid - i);
			}
		}
		while (i <= mid - 1)
			temp[k++] = arr[i++];
		while (j <= r)
			temp[k++] = arr[j++];
		for (i = l; i <= r; i++)
			arr[i] = temp[i];
		return invCount;
	}

}
