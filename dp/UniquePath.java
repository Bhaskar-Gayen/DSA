package dp;

import java.util.Arrays;

public class UniquePath {

	/* Solution using Dynamic Programming-T.C=O(r*c) S.C=O(r*C) */
	public static int uniquePaths(int r, int c) {
		int[][] dp = new int[r][c];
		for (int[] i : dp)
			Arrays.fill(i, -1);

		return loopDpSpaceOptimization(r, c);
	}

	/* recursion */
	static int recursionSolution(int r, int c) {
		if (r == 0 & c == 0)
			return 1;
		if (r < 0 || c < 0)
			return 0;
		return recursionSolution(r, c - 1) + recursionSolution(r - 1, c);
	}

	/* recursion + memorization = top-down */
	static int recursionDP(int r, int c, int[][] dp) {
		if (r == 0 & c == 0)
			return dp[r][c] = 1;
		if (r < 0 || c < 0)
			return 0;
		if (dp[r][c] != -1)
			return dp[r][c];
		return dp[r][c] = recursionDP(r, c - 1, dp) + recursionDP(r - 1, c, dp);
	}

	/* loop + memorization = bottom-up */
	static int loopDP(int r, int c, int[][] dp) {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0 && j == 0)
					dp[i][j] = 1;
				else {
					int left = j > 0 ? dp[i][j - 1] : 0;
					int right = i > 0 ? dp[i - 1][j] : 0;
					dp[i][j] = left + right;
				}
			}
		}
		return dp[r - 1][c - 1];
	}

	/* Space optimization */
	static int loopDpSpaceOptimization(int r, int c) {
		int[] dp = new int[c];

		for (int i = 0; i < c; i++)
			dp[i] = 1;

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				dp[j] += dp[j - 1];
			}
		}

		return dp[c - 1];
	}

}
