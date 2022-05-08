package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * GFG:K Sum Paths Given a binary tree and an integer K. Find the number of
 * paths in the tree which have their sum equal to K.
 */

public class KSumPaths {

	/* Method-1 It's TLE solution */
	public int sumK(TreeNode root, int k) {

		if (root == null)
			return 0;

		return sumK(root.left, k) + sumK(root.right, k) + paths(root, k);
	}

	int paths(TreeNode root, int k) {
		int path = 0;
		if (root == null)
			return path;

		if (k == root.val)
			path++;
		path += paths(root.left, k - root.val);
		path += paths(root.right, k - root.val);
		return path;
	}

	/* Method-2 - optimize solution*/
	int paths = 0;

	public int sumK2(TreeNode root, int targetSum) {

		if (root == null) {
			return paths;
		}
		List<Integer> pres = new ArrayList<>();
		pres.add(root.val);
		dfs(root, targetSum, pres);
		return paths;

	}

	private void dfs(TreeNode root, int targetSum, List<Integer> pres) {

		if (root == null) {
			return;
		}

		int sum = 0;
		for (int i = pres.size() - 1; i >= 0; i--) {
			sum += pres.get(i); // calculate backwords until sum is met
			if (sum == targetSum) {
				paths++;
			}
		}

		if (root.left != null) {
			pres.add(root.left.val);
			dfs(root.left, targetSum, pres);
			pres.remove(pres.size() - 1);
		}

		if (root.right != null) {
			pres.add(root.right.val);
			dfs(root.right, targetSum, pres);
			pres.remove(pres.size() - 1);
		}
	}

}
