package queue;

import java.util.Queue;
import java.util.Stack;

/**
 * CodingNinja: Interleave The First Half Of The Queue With The Second Half If
 * N= 10 and Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] then the output will
 * be Q = [10, 60, 20, 70, 30, 80, 40, 90, 50, 100]
 */

public class QueueInterLeave {

	public static void interLeaveQueue(Queue<Integer> q) {
		int size = q.size();
		if ((size & 1) != 0)
			return;
		Stack<Integer> st = new Stack<>();
		// insert 1st half into stack
		for (int i = 0; i < size / 2; i++)
			st.push(q.remove());

		// insert to queue fron stack
		while (!st.isEmpty())
			q.add(st.pop());

		// push half elements front to back of the queue
		for (int i = 0; i < size / 2; i++)
			q.add(q.remove());

		for (int i = 0; i < size / 2; i++)
			st.push(q.remove());

		while (!st.isEmpty()) {
			q.add(st.pop());
			q.add(q.remove());
		}
	}

}
