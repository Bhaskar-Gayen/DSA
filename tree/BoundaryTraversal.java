package tree;

import java.util.ArrayList;

public class BoundaryTraversal {

	ArrayList<Integer> boundary(TreeNode TreeNode) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (TreeNode == null)
			return ans;
		TreeNode root = TreeNode;
		ans.add(TreeNode.val);
		//left boundary
		traverseLeft(root.left, ans);

		//butttom boundary
		findLeaf(root.left, ans);
		findLeaf(root.right, ans);

		// right boundary
		findRightBoundary(root.right, ans);

		return ans;

	}

	void traverseLeft(TreeNode root, ArrayList<Integer> ans) {
		if (root == null || (root.left == null && root.right == null))
			return;
		ans.add(root.val);
		if (root.left != null)
			traverseLeft(root.left, ans);
		else
			traverseLeft(root.right, ans);
	}

	void findLeaf(TreeNode root, ArrayList<Integer> ans) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			ans.add(root.val);
			return;
		}

		findLeaf(root.left, ans);
		findLeaf(root.right, ans);
	}

	void findRightBoundary(TreeNode root, ArrayList<Integer> ans) {
		if (root == null || (root.left == null && root.right == null))
			return;
		if (root.right != null)
			findRightBoundary(root.right, ans);
		else
			findRightBoundary(root.left, ans);
		ans.add(root.val);
	}

}
