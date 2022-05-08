package tree;

public class DiameterofBinaryTree {
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int d1=diameterOfBinaryTree(root.left);
        int d2=diameterOfBinaryTree(root.right);
        int d3=HeightofTree.height(root.left)+HeightofTree.height(root.right);
        return Math.max(Math.max(d1,d2),d3);
        
    }

}
