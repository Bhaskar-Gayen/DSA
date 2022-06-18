package tree;

class Info{
	int max=Integer.MIN_VALUE;
	int min=Integer.MAX_VALUE;
	boolean isBST=false;
	int size=0;
}
class Data{
	int maxSize=Integer.MIN_VALUE;
}

public class LargestBSTsubtree {

		public static int largestBST(TreeNode root) {
			Data m=new Data();
			solver(root,m);
			return m.maxSize;
		}
		
		static Info solver(TreeNode root, Data m){
			if(root==null){
				Info info=new Info();
				info.isBST=true;
				return info;
			}
			Info left=solver(root.left,m);
			Info right=solver(root.right,m);
			
			Info currInfo= new Info();
			currInfo.size=left.size+right.size+1;
			currInfo.max=Math.max(root.val,right.max);
			currInfo.min=Math.min(root.val,left.min);
			if(left.isBST&&right.isBST&&left.max<root.val&&right.min>root.val)
				currInfo.isBST=true;
			if(currInfo.isBST)
				m.maxSize=Math.max(m.maxSize,currInfo.size);
			return currInfo;
		}
	

}
