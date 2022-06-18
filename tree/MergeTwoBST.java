package tree;

import java.util.ArrayList;

public class MergeTwoBST {
	
	
	/*Method-1 T.C:O(M+N) S.C=O(M+N)*/
	 TreeNode  mergeBST(TreeNode  root1, TreeNode  root2) {
		   ArrayList<Integer> list1=new ArrayList<>();
		   inorder(root1,list1);
		   ArrayList<Integer> list2=new ArrayList<>();
		   inorder(root2,list2);
		   list1=mergeArrayList(list1,list2);
		   return inorderToBST(list1,0,list1.size()-1);

	   }
		
		 ArrayList<Integer> mergeArrayList(ArrayList<Integer>list1, ArrayList<Integer>list2){
			ArrayList<Integer> ans=new ArrayList<>();
			int i=0,j=0;
			while(i<list1.size()&&j<list2.size()){
				if(list1.get(i)<list2.get(j))
					ans.add(list1.get(i++));
				else
					ans.add(list2.get(j++));
			}
			while(i<list1.size())
				ans.add(list1.get(i++));
			while(j<list2.size())
				ans.add(list2.get(j++));
			return ans;
		}
		
		 TreeNode inorderToBST(ArrayList<Integer>list, int s, int e){
			if(s>e)
				return null;
			int mid=(s+e)/2;
			TreeNode root=new TreeNode(list.get(mid));
			root.left=inorderToBST(list,s,mid-1);
			root.right=inorderToBST(list,mid+1,e);
			return root;
		}
		
		 void inorder(TreeNode root, ArrayList<Integer>list){
			if(root==null)
				return;
			inorder(root.left,list);
			list.add(root.val);
			inorder(root.right,list);
		}
		 
	/*Method-2 T.C=O(M+N) S.C=O(H)*/

}
