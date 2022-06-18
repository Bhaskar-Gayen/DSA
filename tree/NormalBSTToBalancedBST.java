package tree;

import java.util.ArrayList;

/**
 * CodeNinja: Normal BST To Balanced BST 
 * Sample Input 1: 10 6 -1 4 -1 -1 -1
 * Sample Output 1: 4 6 10
 */

public class NormalBSTToBalancedBST {

	public static TreeNode balancedBst(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		findInorder(root, list);
		return inOrderToBST(0, list.size() - 1, list);
	}

	static TreeNode inOrderToBST(int s, int e, ArrayList<Integer> list) {
		if (s > e)
			return null;
		int mid = (s + e) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = inOrderToBST(s, mid - 1, list);
		root.right = inOrderToBST(mid + 1, e, list);
		return root;
	}

	static void findInorder(TreeNode root, ArrayList<Integer> list) {
		if (root == null)
			return;
		findInorder(root.left, list);
		list.add(root.val);
		findInorder(root.right, list);
	}

}
