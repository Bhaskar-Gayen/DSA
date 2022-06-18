package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * GFG: K-th Largest Sum Contiguous Subarray Input: N = 3 K = 2 Arr = {3,2,1}
 * Output: 5
 */
public class KthLargestSumContiguousSubarray {

	// Over All T.C=O(N^2LogK)
	public static int kthLargest(int N, int K, int[] arr) {
		int sum = 0;
		// Min Heap
		Queue<Integer> pq = new PriorityQueue<>();
		// O(N^2LogK)
		for (int i = 0; i < N; i++) {
			sum = arr[i];
			for (int j = i + 1; j < N; j++) {
				pq.add(sum);
				if (pq.size() > K)
					pq.poll();
				sum += arr[j];
			}
			pq.add(sum);
			if (pq.size() > K)
				pq.poll();
		}

		return pq.peek();
	}

}
