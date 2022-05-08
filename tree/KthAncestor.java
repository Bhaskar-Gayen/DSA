package tree;

import java.util.Vector;

public class KthAncestor {
	
	/*Method-1 using space*/
	public int kthAncestor(TreeNode root, int k, int node)
    {
        if(root==null)
            return -1;
        Vector<Integer> v=new Vector<>();
        solver(root,node,v);
        if(k>v.size()-1|| k<=0)
            return -1;
        else
            return v.get(v.size()-1-k);
    }
    boolean solver(TreeNode root, int node, Vector<Integer> v){
        if(root==null)
            return false;
        v.add(root.val);
        if(root.val==node)
            return true;
        if(solver(root.left,node,v)||solver(root.right,node,v))
            return true;
        v.remove(v.size()-1);
        return false;
    }
    
    /*Method-2 without using space*/
    int pos=0;
    public int kthAncestor2(TreeNode root, int k, int node)
    {
        pos=k;
        if(root==null)
            return -1;
        
       TreeNode ans= kthAncestorDFS(root,node);
        if(ans==null||ans.val==node)
            return -1;
        else
            return ans.val;
    }
    
    TreeNode kthAncestorDFS(TreeNode root, int node){
        if(root==null)
            return null;
        if(root.val==node)
            return root;
        TreeNode left=kthAncestorDFS(root.left,node);
        TreeNode right=kthAncestorDFS(root.right,node);
        
        if((left!=null&&right==null)||(left==null&&right!=null) ){
            pos--;
            if(pos==0)
                return root;
            else
                return left==null?right:left;
        }
        return null;
    }
}


