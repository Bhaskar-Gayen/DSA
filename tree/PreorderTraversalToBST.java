package tree;

import java.util.ArrayList;

/**
 * CodeStudio: Preorder traversal of a BST 
 * Sample Input 1: 10 4 3 7 40 55 
 * Sample Output 1: 3 5 7 10 40 50
 */

public class PreorderTraversalToBST {
	int i = 0;

	TreeNode prorderToBST(ArrayList<Integer> preorder) {
		if (preorder.size() == 0)
			return null;
		return buildBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	TreeNode buildBST(ArrayList<Integer> preorder, int min, int max) {
		if (i > preorder.size() - 1)
			return null;
		int val = preorder.get(i);
		if (val < min || val > max)
			return null;
		TreeNode root = new TreeNode(val);
		i++;
		root.left = buildBST(preorder, min, root.val);
		root.right = buildBST(preorder, root.val, max);
		return root;
	}

}
