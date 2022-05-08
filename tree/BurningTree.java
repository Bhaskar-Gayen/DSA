package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * GFG: Burning Tree Given a binary tree and a node called target. Find the
 * minimum time required to burn the complete binary tree if the target is set
 * on fire. It is known that in 1 second all nodes connected to a given node get
 * burned.
 */

public class BurningTree {

	public int minTime(TreeNode root, int target) {
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		TreeNode tergetTreeNode = createParentMapping(root, target, parent);

		return burnTree(tergetTreeNode, parent);
	}

	TreeNode createParentMapping(TreeNode root, int target, Map<TreeNode, TreeNode> parent) {
		if (root == null)
			return null;

		TreeNode res = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		parent.put(root, null);

		while (!q.isEmpty()) {
			TreeNode front = q.remove();

			if (front.val == target)
				res = front;

			if (front.left != null) {
				parent.put(front.left, front);
				q.add(front.left);
			}

			if (front.right != null) {
				parent.put(front.right, front);
				q.add(front.right);
			}
		}

		return res;
	}

	int burnTree(TreeNode tergetTreeNode, Map<TreeNode, TreeNode> parent) {
		int time = 0;

		if (tergetTreeNode == null)
			return time;

		Map<TreeNode, Boolean> visited = new HashMap<>();
		visited.put(tergetTreeNode, true);

		Queue<TreeNode> q = new LinkedList<>();
		boolean flage = false;

		q.add(tergetTreeNode);

		while (!q.isEmpty()) {

			flage = false;
			int size = q.size();

			for (int i = 0; i < size; i++) {
				TreeNode front = q.peek();
				q.remove();
				if (front.left != null && !visited.containsKey(front.left)) {
					flage = true;
					q.add(front.left);
					visited.put(front.left, true);
				}

				if (front.right != null && !visited.containsKey(front.right)) {
					flage = true;
					q.add(front.right);
					visited.put(front.right, true);
				}

				if (parent.get(front) != null && !visited.containsKey(parent.get(front))) {
					flage = true;
					q.add(parent.get(front));
					visited.put(parent.get(front), true);
				}
			}
			if (flage)
				time++;
		}
		return time;
	}

}
