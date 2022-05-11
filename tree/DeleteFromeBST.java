package tree;

public class DeleteFromeBST {
	
	 public TreeNode deleteNode(TreeNode root, int key) {
	        if(root==null)
	            return root;
	        if(root.val==key){
	            // 0 child
	            if(root.left==null&&root.right==null)
	                return null;
	            //1 child
	                //left child
	            if(root.left!=null&&root.right==null)
	            	return root.left;
	                //right child
	            if(root.left==null&&root.right!=null)
	                return root.right;
	           
	            //2 child
	            if(root.left!=null&&root.right!=null){
	                int minVal=FindMinFromBST(root.right);
	                root.val=minVal;
	                root.right=deleteNode(root.right,minVal);
	                return root;
	            }
	        }
	        else
	            //left recursion
	            if(root.val>key){
	                root.left=deleteNode(root.left,key);
	                return root;
	            }else{
	                //right recursion
	                root.right=deleteNode(root.right,key);
	                return root;
	            }
	        
	        return root;
	    }
	    int FindMinFromBST(TreeNode root){
	        if(root==null)
	            return Integer.MIN_VALUE;
	        while(root.left!=null)
	            root=root.left;
	        return root.val;
	    }

}
