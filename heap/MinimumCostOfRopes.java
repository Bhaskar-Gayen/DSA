package heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * GFG: Minimum Cost of ropes 
 * Input: n = 4 arr[] = {4, 3, 2, 6} 
 * Output: 29
 */

public class MinimumCostOfRopes {

	long minCost(long arr[], int n) {
		long cost = 0;
		Queue<Long> pq = new PriorityQueue<>();
		for (long v : arr)
			pq.add(v);

		while (pq.size() > 1) {
			long s1 = pq.poll();
			long s2 = pq.poll();
			pq.add(s1 + s2);
			cost += s1 + s2;
		}
		return cost;
	}

}
