package tree;

/**
 * GFG:Sum of the Longest Bloodline of a Tree (Sum of nodes on the longest path
 * from root to leaf node)
 */
public class SumoftheLongestBloodline {

	int maxsum = Integer.MIN_VALUE;
	int maxlen = 0;

	public int sumOfLongRootToLeafPath(TreeNode root) {
		int len = 0;
		int sum = 0;

		solver(root, len, sum);

		return maxsum;
	}

	void solver(TreeNode root, int len, int sum) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			sum += root.val;
			if (len >= maxlen && sum > maxsum) {
				maxlen = len;
				maxsum = sum;
			}
			return;
		}

		sum += root.val;
		solver(root.left, len + 1, sum);
		solver(root.right, len + 1, sum);
	}

}
