package array;

import java.util.ArrayList;

public class MaximumArraySumfromBothEnd {
	
	/* Maximum array sum from both end of a array */
	public int maxSumEnd(ArrayList<Integer> A, int B) {
		int sumsofer = 0;
		for (int i = 0; i < B; i++)
			sumsofer += (int) A.get(i);
		int f = B - 1, r = A.size() - 1;
		int maxsum = sumsofer;
		while (f >= 0 && r >= 0) {
			sumsofer += (int) A.get(r--);
			sumsofer -= (int) A.get(f--);
			maxsum = Math.max(sumsofer, maxsum);
		}
		return maxsum;
	}

}
