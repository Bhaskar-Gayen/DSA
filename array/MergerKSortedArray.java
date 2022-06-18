package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * GFG: Merge k Sorted Arrays Input: K = 3 arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
 * Output: 1 2 3 4 5 6 7 8 9
 */

public class MergerKSortedArray {

	// Over all time Complexity O(N^2) we can solve it by Min Heap
	public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
		ArrayList<Integer> list = new ArrayList<>();
		// T.C=O(N^2)
		for (int i = 0; i < K; i++) {
			for (int j = 0; j < arr[i].length; j++)
				list.add(arr[i][j]);
		}
		// O(NLogN)
		Collections.sort(list);
		return list;
	}

}
