package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode: Construct Binary Tree from Inorder and Postorder Traversal Given
 * two integer arrays inorder and postorder where inorder is the inorder
 * traversal of a binary tree and postorder is the postorder traversal of the
 * same tree, construct and return the binary tree.
 */

public class ConstractBTPostIN {

	int postIndex;

	public TreeNode buildTree(int[] in, int[] post) {
		int n = in.length;
		postIndex = n - 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++)
			map.put(in[i], i);

		TreeNode ans = solver(in, post, 0, n - 1, n, map);
		return ans;

	}

	TreeNode solver(int in[], int post[], int start, int end, int size, Map<Integer, Integer> map) {
		if (postIndex < 0 || start > end)
			return null;

		int element = post[postIndex--];
		//create node
		TreeNode newNode = new TreeNode(element);

		int index = map.get(element);

		newNode.right = solver(in, post, index + 1, end, size, map);
		newNode.left = solver(in, post, start, index - 1, size, map);

		return newNode;
	}

}
