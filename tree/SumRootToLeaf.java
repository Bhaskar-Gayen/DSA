package tree;

public class SumRootToLeaf {
	int ans=0;
	int subAns=0;
	public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        
        solver(root);
        return ans;
    }
    void solver(TreeNode root){
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            subAns+=subAns*10+root.val;
            ans+=subAns;
            subAns/=10;
            return;
        }
            
        subAns+=subAns*10+root.val;
        solver(root.left);
        solver(root.right);
        subAns/=10;
    }

}
