package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: Construct Binary Tree from Preorder and Inorder Traversal Given two
 * integer arrays preorder and inorder where preorder is the preorder traversal
 * of a binary tree and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */

public class ConstractBinaryTree {

	int preorderIndex = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = inorder.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(inorder[i], i);

		TreeNode ans = solver(inorder, preorder, 0, n - 1, n, map);
		return ans;
	}

	TreeNode solver(int inorder[], int preorder[], int start, int end, int size, Map<Integer, Integer> map) {
		if (preorderIndex >= size || start > end)
			return null;

		int element = preorder[preorderIndex++];

		// create node
		TreeNode newNode = new TreeNode(element);

		int index = map.get(element);

		newNode.left = solver(inorder, preorder, start, index - 1, size, map);
		newNode.right = solver(inorder, preorder, index + 1, end, size, map);

		return newNode;
	}

}
