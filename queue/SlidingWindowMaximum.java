package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * GFG: Sliding Window Maximum (Maximum of all subarrays of size k) 
 * Input: arr[]= {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3 Output: 3 3 4 5 5 5 6
 */

public class SlidingWindowMaximum {

	/*Method-1: T.C=O(NLogN) S.C=O(K)*/
	static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {

		// create MaxHeap
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

		ArrayList<Integer> ans = new ArrayList<>();

		int i = 0;
		for (; i < k; i++)
			q.add(arr[i]);
		ans.add(q.peek());
		q.remove(arr[0]);
		for (; i < n; i++) {
			q.add(arr[i]);
			ans.add(q.peek());
			q.remove(arr[i - k + 1]);
		}

		return ans;
	}
	
	/*Method-2*/
	

}
