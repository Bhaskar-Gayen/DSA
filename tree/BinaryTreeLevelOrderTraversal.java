package tree;

/**
 *LeetCode: 102. Binary Tree Level Order Traversal
 *Input: root = [3,9,20,null,null,15,7]
 *Output: [[3],[9,20],[15,7]]*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
            return ans;
        //step-1: make a queue
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.add(root);
        while(!queue1.isEmpty()||!queue2.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            TreeNode front=null;
            while(!queue1.isEmpty()){
                front=queue1.poll();
                if(front.left!=null)
                    queue2.add(front.left);
                if(front.right!=null)
                    queue2.add(front.right);
                temp.add(front.val);
            }
            if(temp.size()>0)
              ans.add(temp);
            temp=new ArrayList<>();
            
            while(!queue2.isEmpty()){
                front=queue2.poll();
                if(front.left!=null)
                    queue1.add(front.left);
                if(front.right!=null)
                    queue1.add(front.right);
                temp.add(front.val);
            }
            if(temp.size()>0)
               ans.add(temp);
            temp=new ArrayList<>(); 
        }
        return ans;
    }

}
