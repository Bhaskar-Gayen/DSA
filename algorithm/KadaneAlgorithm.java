package algorithm;

/**
 * Kadane's Algorithm Find the contiguous sub-array(containing at least one
 * number) which has the maximum sum and return its sum 
 * Input: N = 5 Arr[] ={1,2,3,-2,5} Output: 9
 */

public class KadaneAlgorithm {

	long maxSubarraySum(int nums[], int n) {
		long currSum = 0, maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			currSum += nums[i];
			maxSum = Math.max(currSum, maxSum);
			if (currSum < 0)
				currSum = 0;
		}
		return maxSum;
	}

}
