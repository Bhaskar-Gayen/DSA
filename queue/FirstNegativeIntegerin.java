package queue;

import java.util.ArrayDeque;

/**
 * GeeksForGeek: First negative integer in every window of size k Input : N = 5
 * A[] = {-8, 2, 3, -6, 10} K = 2 Output : -8 0 -6 -6
 */

public class FirstNegativeIntegerin {

	public long[] printFirstNegativeInteger(long A[], int N, int K) {
		long[] ans = new long[N - K + 1];
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		int index = 0, i = 0;

		// process 1st window
		for (; i < K; i++)
			if (A[i] < 0)
				dq.addLast(i);
		if (dq.size() > 0)
			ans[index++] = A[dq.getFirst()];
		else
			ans[index++] = 0;
		for (; i < N; i++) {
			if (!dq.isEmpty() && i - dq.getFirst() >= K)
				dq.pollFirst();
			if (A[i] < 0)
				dq.addLast(i);

			if (dq.size() > 0)
				ans[index++] = A[dq.getFirst()];
			else
				ans[index++] = 0;
		}
		return ans;
	}

}
