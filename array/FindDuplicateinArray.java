package array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateinArray {
	
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
