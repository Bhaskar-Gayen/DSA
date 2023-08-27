package tree;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class PrintLeafNodesPreorderTraversalBST {
	
	//Approach -1
	 int index=0;
	    public int[] leafNodes(int arr[], int N)
	    {
	        List<Integer> v=new Vector<>();
	        
	        //copy in new array
	        int[] inorder=Arrays.copyOf(arr,arr.length);
	        //sort the array for inorder
	        Arrays.sort(inorder);
	        
	        leafNodeSearch(arr,inorder,0,N-1,N,v);
	        // System.out.println(Arrays.toString(inorder));
	        int[] ans=new int[v.size()];
	        for(int i=0;i<ans.length;i++){
	            ans[i]=v.get(i);
	        }
	        return ans;
	    }
	    
	    void leafNodeSearch(int[] preorder, int[] inorder, int l, int r, int n, List<Integer> ans){
	        
	        if(l<0|| l>r||r>=n) return;
	        
	        if(l==r){
	            ans.add(inorder[l]);
	            index++;
	            return;
	        }
	        
	        //search the element in inorder array
	        int loc=binarySearch(inorder, preorder[index]);
	        // System.out.println(loc+ " "+ preorder[index]);
	        index++;
	        
	        //search in LST
	        leafNodeSearch(preorder,inorder,l,loc-1,n,ans);
	        
	        //search on RST
	        leafNodeSearch(preorder,inorder,loc+1,r,n,ans);
	        
	    }
	    
	    int binarySearch(int[] arr, int key){
	        
	        int l=0, r=arr.length-1;
	        while(l<=r){
	            int mid=l+(r-l)/2;
	            if(arr[mid]==key) return mid;
	            else
	               if(arr[mid]<key) l=mid+1;
	               else r=mid-1;
	        }
	        
	        return -1;
	    }
	    
	    //Approach -2
	    public int[] leafNodes2(int arr[], int N)
	    {
	        List<Integer> v=new Vector<>();
	        
	        Stack<Integer> st=new Stack<>();
	        //push top root
	        st.push(arr[0]);
	        
	        for(int i=1;i<arr.length;i++){
	            if(st.peek()>arr[i]) st.push(arr[i]);
	            else {
	                int val=st.peek(), cnt=0;
	                while(!st.isEmpty()&&st.peek()<arr[i]){
	                    st.pop();
	                    cnt++;
	                }
	                st.push(arr[i]);
	                if(cnt>1)v.add(val);
	            }
	        }
	        
	        v.add(st.pop());
	        
	        int[] ans=new int[v.size()];
	        for(int i=0;i<ans.length;i++){
	            ans[i]=v.get(i);
	        }
	        return ans;
	    }

}
