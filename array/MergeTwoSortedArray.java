package array;

public class MergeTwoSortedArray {
	
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

}
