package arraypack;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	/*
	 * LeetCode: 852. Peak Index in a Mountain Array Input: arr = [0,10,5,2] Output:1
	 */
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

	/*
	 * Split Array Largest Sum Input: nums = [7,2,5,10,8], m = 2 Output: 18
	 */
	public int splitArray(int[] arr, int student) {
		int s = 0;
		int e = 0;
		int ans = -1;
		for (int i = 0; i < arr.length; i++)
			e += arr[i];
		while (s <= e) {
			int mid = (s + e) / 2;
			if (isFeasible(arr, mid, student)) {
				ans = mid;
				e = mid - 1;
			} else
				s = mid + 1;
		}
		return ans;

	}

	static boolean isFeasible(int[] arr, int page, int student) {
		int stu = 1, pagesum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (pagesum + arr[i] > page) {
				stu++;
				if (stu > student || arr[i] > page)
					return false;
				pagesum = arr[i];
			} else
				pagesum += arr[i];
		}
		return true;
	}

	/* Merge two sorted array O(m+n) */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// edge cases
		if (n == 0)
			return;

		int i = m - 1, j = n - 1, k = m + n - 1;
		while (j >= 0) {
			if (i >= 0 && nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}
	}

	/* Maximum array sum from both end of a array */
	public int maxSumEnd(ArrayList<Integer> A, int B) {
		int sumsofer = 0;
		for (int i = 0; i < B; i++)
			sumsofer += (int) A.get(i);
		int f = B - 1, r = A.size() - 1;
		int maxsum = sumsofer;
		while (f >= 0 && r >= 0) {
			sumsofer += (int) A.get(r--);
			sumsofer -= (int) A.get(f--);
			maxsum = Math.max(sumsofer, maxsum);
		}
		return maxsum;
	}

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

	/* Find one single duplicate element from an array */
	public int finDuplicate(int arr[]) {
		int ans = arr[0];
		for (int i = 1; i < arr.length; i++)
			ans ^= arr[i];
		for (int i = 1; i < arr.length; i++)
			ans ^= i;
		return ans;
	}

	/* Find list of Duplicate elements from an array */
	public List<Integer> findDuplicates(int[] arr) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			int abs_val = Math.abs(arr[i]);
			if (arr[abs_val - 1] > 0)
				arr[abs_val - 1] = -arr[abs_val - 1];
			else
				list.add(abs_val);
		}
		return list;
	}

}