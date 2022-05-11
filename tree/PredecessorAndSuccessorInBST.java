package tree;

/**
 * GFG: Predecessor and Successor
 * There is BST given with root node with key part as an integer only. You need to find the in-order successor and predecessor of a given key.*/
public class PredecessorAndSuccessorInBST {
	
	 void findPreSuc(TreeNode root, int key)
	    {
	      if(root==null)
	        return;
	        
	        TreeNode curr=root;
	        TreeNode succ,pre;
	        while(curr!=null){
	            if(curr.val>key){
	                succ=curr;
	                curr=curr.left;
	            }else
	                curr=curr.right;
	        }
	        
	        curr=root;
	        while(curr!=null){
	            if(curr.val<key){
	                pre=curr;
	                curr=curr.right;
	            }
	            else
	                curr=curr.left;
	        }
	        
	    }

}

/*
 * public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
		ArrayList<Integer> ans=new ArrayList<>();
		if(root==null)
			return ans;
		TreeNode node=findNode(root,key);
		ans.add(findPredecessor(node.left));
		ans.add(findSuccessor(node.right));
		return ans;
	}
	static TreeNode findNode(TreeNode root, int key){
		if(root==null)
			return null;
		if(root.val==key)
			return root;
		TreeNode left=findNode(root.left,key);
		if(left!=null)
			return left;
		return findNode(root.right,key);
	}
	static Integer findPredecessor(TreeNode root){
		if(root==null) return null;
		while(root.right!=null)
			root=root.right;
		return root.val;
	}
	static Integer findSuccessor(TreeNode root){
		if(root==null) return null;
		while(root.left!=null)
			root=root.left;
		return root.val;
	}*/
 