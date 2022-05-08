package array;

import java.util.ArrayList;

/**
 * GFG: Find index Subarray with given sum 
 * Input: N = 5, S = 12 A[] = {1,2,3,7,5} Output: 2 4
 */

public class SubarraywithGivenSum {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
		ArrayList<Integer> ans = new ArrayList<>();
		long sum = 0;
		int start = 0, end = 0, i = 0;
		for (; i < n; i++) {
			sum += arr[i];
			while (sum > s && start < i) {
				sum -= arr[start];
				start++;
			}
			if (sum == s) {
				end = i;
				ans.add(++start);
				ans.add(++end);
				return ans;
			}

		}

		ans.add(-1);
		return ans;
	}

}
