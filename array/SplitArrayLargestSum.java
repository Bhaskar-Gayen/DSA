package array;

/*
 * Split Array Largest Sum Input: nums = [7,2,5,10,8], m = 2 Output: 18
 */

public class SplitArrayLargestSum {
	
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

}
