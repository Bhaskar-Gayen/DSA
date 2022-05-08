package tree;

public class BalanceBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isBalanced(root.left) && isBalanced(root.right)
				&& Math.abs(HeightofTree.height(root.left) - HeightofTree.height(root.right)) <= 1;

	}

}
