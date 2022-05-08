package array;

import java.util.HashMap;
import java.util.Map;

/**
 * GFG: Find the number of Subarrays with given sum Input: N=5 sum=-10 arr[] = {10, 2, -2, -20, 10 } 
 * Output: 3
 */

public class CountSubarraySum {

	public static int subArraySum(int[] arr, int n, int sum) {
		int count = 0, currSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			currSum += arr[i];
			if (currSum == sum)
				count++;
			if (map.containsKey(currSum - sum))
				count += map.get(currSum - sum);
			map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		}
		return count;
	}

}
