package array;

public class BinarySearch {
	
	/* Binary Search in an Array Iterative Method */
	public int binarySearch(int arr[], int start, int end, int key) {
		if (arr == null)
			return 0;
		if (start <= end) {
			int mid = (start + end) / 2;

			if (arr[mid] == key)
				return mid;
			else {
				if (arr[mid] > key)
					end = mid - 1;
				else
					start = mid + 1;
				return binarySearch(arr, start, end, key);
			}
		}
		return -1;
	}

}
