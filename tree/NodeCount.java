package tree;

/**
 * LeetCOde: Count Complete Tree Nodes Input: root = [1,2,3,4,5,6] Output: 6
 */

public class NodeCount {

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + countNodes(root.left) + countNodes(root.right);
	}

}
