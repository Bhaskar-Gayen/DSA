package tree;

/**
 * GFG: Flatten binary tree to linked list Given a binary tree, flatten it into
 * linked list in-place. Usage of auxiliary data structure is not allowed. After
 * flattening, left of each node should point to NULL and right should contain
 * next node in preorder.
 */

public class FlattenBinaryTreetoLinkedList {

	/* Morris Traversal T.C=O(N) S.C=O(1) */
	public static void flatten(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			if (curr.left != null) {
				TreeNode prev = curr.left;
				while (prev.right != null)
					prev = prev.right;
				prev.right = curr.right;
				curr.right = curr.left;
				curr.left = null;
			}
			curr = curr.right;
		}
	}

}
