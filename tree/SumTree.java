package tree;

/**
 * GFG: Sum Tree 
 * Given a Binary Tree. Return true if, for every node X in the
 * tree other than the leaves, its value is equal to the sum of its left
 * subtree's value and its right subtree's value. Else return false.
 */

public class SumTree {
	/* Method-1 T.C=O(N^2) */
	boolean isSumTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.val == sum(root.left) + sum(root.right))
			return isSumTree(root.left) && isSumTree(root.right);
		else
			return false;

	}

	/* Method-2 T.C=O(N^2) */
	boolean isSumTree2(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;
		if (isSumTree(root.left) && isSumTree(root.right))
			if (root.val == sum(root.left) + sum(root.right))
				return true;
			else
				return false;

		return false;

	}

	// find the sum of root+left+right;
	int sum(TreeNode root) {
		if (root == null)
			return 0;
		return sum(root.left) + sum(root.right) + root.val;
	}

	/* Method-3 T.C=O(N) */
	boolean isSumTree3(TreeNode root) {
		if (root == null || isLeaf(root))
			return true;

		if (isSumTree(root.left) && isSumTree(root.right)) {
			if (validSum(root))
				return true;
			else
				return false;

		}
		return false;
	}

	boolean validSum(TreeNode root) {
		int ls = 0;
		int rs = 0;
		if (root.left != null) {
			if (isLeaf(root.left))
				ls = root.left.val;
			else
				ls = 2 * root.left.val;
		}
		if (root.right != null) {
			if (isLeaf(root.right))
				rs = root.right.val;
			else
				rs = 2 * root.right.val;
		}
		return root.val == ls + rs;
	}

	boolean isLeaf(TreeNode root) {
		if (root == null)
			return false;
		return (root.left == null) && (root.right == null);
	}

}
