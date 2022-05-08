package tree;
/**LeetCode: Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.*/

public class LowestCommonAncestorinBT {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return root;
        if(root==p||root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null)
            return root;
        else
           if(left!=null&&right==null)
               return left;
            else
                if(left==null&&right!=null)
                    return right;
                else
                    return null;
    }

}
