package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * LeetCode: All Nodes Distance K in Binary Tree Given the root of a binary
 * tree, the value of a target node target, and an integer k, return an array of
 * the values of all nodes that have a distance k from the target node
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2 Output: [7,4,1]
 */

public class NodesDistanceK {

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> ans = new ArrayList<>();
		// for single node tree
		if (root.left == null && root.right == null && k > 0)
			return ans;
		Map<TreeNode, TreeNode> parent = new HashMap<>();

		mapToParent(root, target, parent);
		Map<TreeNode, Boolean> visited = new HashMap<>();

		findNodes(target, k, ans, 0, parent, visited);
		return ans;
	}

	void mapToParent(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> map) {
		if (root == null)
			return;
		map.put(root, null);

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			TreeNode front = q.remove();

			if (front.left != null) {
				map.put(front.left, front);
				q.add(front.left);
			}
			if (front.right != null) {
				map.put(front.right, front);
				q.add(front.right);
			}
		}
	}

	void findNodes(TreeNode root, int k, List<Integer> ans, int distance, Map<TreeNode, TreeNode> parent, Map<TreeNode, Boolean> visited) {
		if (root == null)
			return;
		visited.put(root, true);

		if (distance == k) {
			ans.add(root.val);
			return;
		}

		if (root.left != null && !visited.containsKey(root.left))
			findNodes(root.left, k, ans, distance + 1, parent, visited);

		if (root.right != null && !visited.containsKey(root.right))
			findNodes(root.right, k, ans, distance + 1, parent, visited);

		if (parent.get(root) != null && !visited.containsKey(parent.get(root)))
			findNodes(parent.get(root), k, ans, distance + 1, parent, visited);

	}

}
