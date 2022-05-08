package array;

/*
 * LeetCode: 852. Peak Index in a Mountain Array Input: arr = [0,10,5,2] Output:1
 */

public class PeakIndexinMountainArray {
	
	public int peakIndexInMountainArray(int[] arr) {
		int s = 0, e = arr.length - 1;
		while (s <= e) {
			int mid = (s + e) / 2;
			if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
				return mid;
			} else {
				if (arr[mid] < arr[mid + 1])
					s = mid + 1;
				else
					e = mid;
			}
		}
		return -1;
	}

}
