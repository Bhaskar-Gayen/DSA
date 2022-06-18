package heap;

/**
 * GFG: is BT is a Heap
 * */

public class IsBinaryTreeHeap {
	
	boolean isHeap(Node tree) {
        int totalCount=nodeCount(tree);
        return isCompleteBT(tree,1,totalCount)&&isMaxHeap(tree);
    }
    
    boolean isMaxHeap(Node root){
        if(root.left==null&&root.right==null)
            return true;
        if(root.right==null){
            return root.data>root.left.data;
        }else
        return root.data>root.left.data&&root.data>root.right.data
        &&isMaxHeap(root.left)&&isMaxHeap(root.right);
        
    }
    
    boolean isCompleteBT(Node root, int index, int totalCount){
        if(root==null)
            return true;
        if(index>totalCount)
            return false;
        if(root.left==null&&root.right!=null)
            return false;
        return isCompleteBT(root.left, index*2, totalCount)
            &&isCompleteBT(root.right,index*2+1,totalCount);
    }
    
    
    int nodeCount(Node root){
        if(root==null)
            return 0;
        return 1+nodeCount(root.left)+nodeCount(root.right);
    }

}
