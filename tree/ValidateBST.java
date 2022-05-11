package tree;

/**
 * LeetCode: Validate Binary Search Tree 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 */
public class ValidateBST {

	public boolean isValidBST(TreeNode root) {
		return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean isValid(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val <= min || root.val >= max)
			return false;
		else
			return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);

	}

}
