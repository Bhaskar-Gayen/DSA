package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode: Binary Tree Zigzag Level Order Traversal 
 * Input: root =[3,9,20,null,null,15,7] Output: [[3],[20,9],[15,7]]
 */

public class ZigZagTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		// Create stack for tracking each lavel node
		Stack<TreeNode> currLevel = new Stack<>();
		Stack<TreeNode> nextLevel = new Stack<>();
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;

		currLevel.push(root);
		boolean ltr = true;
		List<Integer> tempAns = new ArrayList<>();
		while (!currLevel.isEmpty()) {
			TreeNode temp = currLevel.pop();
			tempAns.add(temp.val);
			if (ltr) {
				if (temp.left != null)
					nextLevel.push(temp.left);
				if (temp.right != null)
					nextLevel.push(temp.right);
			} else {
				if (temp.right != null)
					nextLevel.push(temp.right);
				if (temp.left != null)
					nextLevel.push(temp.left);
			}
			// swap betwween stack
			if (currLevel.isEmpty()) {
				Stack<TreeNode> tempst = currLevel;
				currLevel = nextLevel;
				nextLevel = tempst;
				ltr = !ltr;
				ans.add(tempAns);
				tempAns = new ArrayList<>();
			}

		}
		return ans;
	}

}
