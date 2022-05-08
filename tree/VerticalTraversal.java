package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VerticalTraversal {

	/* Method-1 T.C: O(N^2) */
	static int min = 0;
	static int max = 0;

	// Function to find the vertical order traversal of Binary Tree.-
	static ArrayList<Integer> verticalOrder(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();

		if (root == null)
			return ans;

		findMinMax(root, 0);

		for (int lineNo = min; lineNo <= max; lineNo++)
			traverseVertical(root, lineNo, 0, ans);
		return ans;
	}

	static void findMinMax(TreeNode root, int hd) {
		if (root == null)
			return;
		if (hd < min)
			min = hd;
		if (hd > max)
			max = hd;
		findMinMax(root.left, hd - 1);
		findMinMax(root.right, hd + 1);
	}

	static void traverseVertical(TreeNode root, int lineNo, int hd, ArrayList<Integer> ans) {
		if (root == null)
			return;
		if (hd == lineNo)
			ans.add(root.val);

		traverseVertical(root.left, lineNo, hd - 1, ans);
		traverseVertical(root.right, lineNo, hd + 1, ans);
	}

	/* Method-2 T.C=O(NLogn) */

	public List<List<Integer>> verticalTraversal(TreeNode root) {

		List<List<Integer>> ans = new ArrayList<>();

		if (root == null)
			return ans;

		TreeMap<Integer, List<Integer>> map = new TreeMap<>();

		findMinMax2(root, 0, map);

		for (int hd = min; hd <= max; hd++) {
			ans.add(map.get(hd));
		}

		return ans;
	}

	static void findMinMax2(TreeNode root, int hd, TreeMap<Integer, List<Integer>> map) {
		if (root == null)
			return;
		if (hd < min)
			min = hd;
		if (hd > max)
			max = hd;
		List<Integer> list = map.get(hd);
		if (list == null) {
			list = new ArrayList<>();
			list.add(root.val);
		} else
			list.add(root.val);
		map.put(hd, list);

		findMinMax2(root.left, hd - 1, map);
		findMinMax2(root.right, hd + 1, map);

	}

}
