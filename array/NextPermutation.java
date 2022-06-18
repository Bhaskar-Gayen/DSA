package array;

/**
 * LeetCode: 31. Next Permutation 
 * Input: nums = [1,2,3] Output: [1,3,2] 
 * Input:nums = [3,2,1] Output: [1,2,3]
 */

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		int len = nums.length;
		if (len <= 1)
			return;
		int i = len - 2;
		for (; i >= 0; i--)
			if (nums[i] < nums[i + 1])
				break;
		if (i >= 0) {
			int j = len - 1;
			for (; nums[j] <= nums[i]; j--)
				;
			swap(nums, i, j);
		}
		reverse(nums, i + 1, nums.length - 1);
	}

	void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	void reverse(int[] arr, int s, int e) {
		while (s < e) {
			swap(arr, s, e);
			s++;
			e--;
		}
	}

}
