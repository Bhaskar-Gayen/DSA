package tree;

/**
 * LeetCode:  Kth Smallest Element in a BST
 * Input: root = [3,1,4,null,2], k = 1 Output: 1
 */

public class KthSmallestElementinBST {
	

	    int pos=0;
	    public int kthSmallest(TreeNode root, int k) {
	        if(root==null)
	            return -1;
	        return findKthSmallest(root, k);
	    }
	    int findKthSmallest(TreeNode root, int k){
	        if(root==null)return -1;
	        
	       int left= findKthSmallest(root.left,k);
	        if(left!=-1)
	            return left;
	        pos++;
	        if(pos==k)
	            return root.val;
	        
	    return findKthSmallest(root.right,k);
	    }
	    

}
