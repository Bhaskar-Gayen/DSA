package tree;

public class MaximumSumOfNonAdajacentNode {
	
static class Pair{
        
        int first;
        int second;
        Pair(){
            first=second=0;
        }
    }
    //Function to return the maximum sum of non-adjacent TreeNodes.
    static int getMaxSum(TreeNode root)
    {
       Pair pair= solver(root);
        
        return Math.max(pair.first,pair.second);
    }
    
   static Pair solver(TreeNode root){
        if(root==null){
            Pair pair=new Pair();
            return pair;
        }
        
        Pair left=solver(root.left);
        Pair right=solver(root.right);
        
        Pair res=new Pair();
        //include current TreeNode
        res.first= root.val+left.second+right.second;
        //exclude current TreeNode
        res.second=Math.max(left.first,left.second)+Math.max(right.first,right.second);
        
        return res;
        
    }

}
