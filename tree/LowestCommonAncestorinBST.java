package tree;

/**
 * GFG:Lowest Common Ancestor in a BST Given a Binary Search Tree (with all
 * values unique) and two node values. Find the Lowest Common Ancestors of the
 * two nodes in the BST.
 */

public class LowestCommonAncestorinBST {

	TreeNode LCA(TreeNode root, int p, int q) {

		if (root == null)
			return root;

		if (root.val > p && root.val > q)
			return LCA(root.left, p, q);
		if (root.val < p && root.val < q)
			return LCA(root.right, p, q);
		return root;
	}

}
