package queue;

import java.util.Queue;

/**
 * GFG: Reverse First K elements of Queue 
 * Input: 5 3 1 2 3 4 5 
 * Output: 3 2 1 4 5
 */

public class ReverseFirstKelementsofQueue {

	// Function to reverse first k elements of a queue.
	public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
		reverseK(q, k);
		reverse(q, q.size() - k);
		return q;
	}

	void reverseK(Queue<Integer> q, int k) {
		if (k == 0) {
			return;
		}
		int key = q.remove();
		reverseK(q, k - 1);
		q.add(key);
	}

	void reverse(Queue<Integer> q, int k) {
		if (k == 0) {
			return;
		}
		int key = q.remove();
		q.add(key);
		reverse(q, k - 1);

	}

}
