package tree;

/**
 * Count only leaf node in abinary tree*/
public class CountLeafNode {
	
	public  int noOfLeafNodes(TreeNode root) {
		if(root==null)
			return 0;
		if(root.left==null&&root.right==null)
			return 1+noOfLeafNodes(root.left)+noOfLeafNodes(root.right);
		else
			return noOfLeafNodes(root.left)+noOfLeafNodes(root.right);
	}

}
