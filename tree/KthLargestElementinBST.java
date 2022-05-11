package tree;

/**
 * GFG: Kth largest element in BST Given a Binary search tree. Your task is to
 * complete the function which will return the Kth largest element without doing
 * any modification in Binary Search Tree.
 */

public class KthLargestElementinBST {

	int i = 0;

	// return the Kth largest element in the given BST rooted at 'root'
	public int kthLargest(TreeNode root, int k) {
		if (root == null)
			return -1;
		return findKthLargest(root, k);
	}

	int findKthLargest(TreeNode root, int k) {
		if (root == null)
			return -1;
		int right = findKthLargest(root.right, k);
		if (right != -1)
			return right;
		i++;
		if (i == k)
			return root.val;
		return findKthLargest(root.left, k);
	}

}
